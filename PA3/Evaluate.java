
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Evaluate {

    private Map<String, Double> variables = new HashMap<>();
    private Map<String, FunctionDeclNode> functions = new HashMap<>();
    public List<String> semanticErrors = new ArrayList<>();

    public double evaluate(AstNodes node) {
    	
    	if (node instanceof FunctionDeclNode) {
            // Function declaration doesn't produce a value in this context, just registers the function.
            FunctionDeclNode funcDecl = (FunctionDeclNode) node;
            functions.put(funcDecl.functionName, funcDecl);
            return 0.0;  // Return 0.0 for the function declaration itself.

        } else if (node instanceof LetNode) {
            LetNode letNode = (LetNode) node;
            double value = evaluate(letNode.assignedExpr);
            // Temporarily store the current value of the variable if it exists to restore it later.
            Double oldValue = variables.get(letNode.variableName);
            variables.put(letNode.variableName, value);
            double result = evaluate(letNode.inExpr);
            // Restore the old value if it existed.
            if (oldValue != null) {
                variables.put(letNode.variableName, oldValue);
            } else {
                variables.remove(letNode.variableName);
            }
            return result;

        }
    	else if (node instanceof NegNode) {
            NegNode negNode = (NegNode) node;
            return -evaluate(negNode.expr);  // Apply negation.

        } else if (node instanceof FunctionCallNode) {
            FunctionCallNode funcCall = (FunctionCallNode) node;
            FunctionDeclNode funcDecl = functions.get(funcCall.functionName);
            //error warning
            if (funcDecl == null) {
            	semanticErrors.add("Error: Undefined function " + funcCall.functionName + " detected.");
                return 0.0;
            }
         // Argument Mismatch Check
            if (funcCall.arguments.size() != funcDecl.parameters.size()) {
                semanticErrors.add("Error: The number of arguments of " + funcCall.functionName +
                                   " mismatched, Required: " + funcDecl.parameters.size() +
                                   ", Actual: " + funcCall.arguments.size());
                return 0.0;
            }
         // Evaluate the arguments in the current scope and store them in a new map for the function scope.
            Map<String, Double> newScope = new HashMap<>(variables);
            
            for (int i = 0; i < funcCall.arguments.size(); i++) {
                String param = funcDecl.parameters.get(i);
                double argValue = evaluate(funcCall.arguments.get(i));
                newScope.put(param, argValue);
            }
            
          //Save the current scope.
            Map<String, Double> oldScope = new HashMap<>(variables);
            // Replace the current scope with the new scope for the function body evaluation.
            variables = newScope;

            double result = evaluate(funcDecl.body);

            // Restore the old scope after the function call.
            variables = oldScope;
            return result;

        }else if (node instanceof InfixNode) {
            InfixNode infixNode = (InfixNode) node;
            double left = evaluate(infixNode.left);
            double right = evaluate(infixNode.right);
            switch (infixNode.op) {
                case "ADD":
                    return left + right;
                case "SUB":
                    return left - right;
                case "MUL":
                    return left * right;           
                default:
                	//DIV case
                	// you don't have to worry about divison error.  
                	return left / right;
        
            }
            
        } else if (node instanceof NumberNode) {
            NumberNode numberNode = (NumberNode) node;
            return numberNode.value;
            
        } else if (node instanceof IdNode) { 
            IdNode idNode = (IdNode) node;
            if (variables.containsKey(idNode.IdName)) {
                return variables.get(idNode.IdName);
            } else {
            	// Free Identifier Check
                semanticErrors.add("Error: Free identifier " + idNode.IdName + " detected.");
                return 0.0;
            }
            
        } else if (node instanceof AssignNode) {
        	 AssignNode assignNode = (AssignNode) node;
             double value = evaluate(assignNode.right);
             String id = assignNode.idName;
             variables.put(id, value);
             return 0.0; 
        } 
         
       
            return 0.0; // Default value for any other node
        
    }
}
