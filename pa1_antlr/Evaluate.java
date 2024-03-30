
import java.util.HashMap;
import java.util.Map;

class Evaluate {

    private Map<String, Double> variables = new HashMap<>();

    public double evaluate(AstNodes node) {
        if (node instanceof InfixNode) {
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
                System.err.println("Undefined variable: " + idNode.IdName);
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
