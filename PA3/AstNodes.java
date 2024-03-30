
import java.util.ArrayList;
import java.util.List;


class AstNodes {}

class ProgNode extends AstNodes {
	public List<AstNodes> expressions = new ArrayList<>();
	

	public void addExpression(AstNodes e) {
		if(e != null)
			expressions.add(e);
		
		}
	

}


class FunctionDeclNode extends AstNodes {
    String functionName;
    List<String> parameters = new ArrayList<>();
    AstNodes body;

    FunctionDeclNode(String functionName, List<String> parameters, AstNodes body) {
        this.functionName = functionName;
        this.parameters = parameters;
        this.body = body;
    }
}


class FunctionCallNode extends AstNodes {
    String functionName;
    List<AstNodes> arguments = new ArrayList<>();

    FunctionCallNode(String functionName, List<AstNodes> arguments) {
        this.functionName = functionName;
        this.arguments = arguments;
    }
}

class LetNode extends AstNodes {
    String variableName;
    AstNodes assignedExpr;
    AstNodes inExpr;

    LetNode(String variableName, AstNodes assignedExpr, AstNodes inExpr) {
        this.variableName = variableName;
        this.assignedExpr = assignedExpr;
        this.inExpr = inExpr;
    }
}


	
class InfixNode extends AstNodes {
    String op; // e.g. ADD, SUB, MUL, DIV
    AstNodes left, right;
}

class NegNode extends AstNodes{
	String op; // eg. NEG
	AstNodes expr;
}

class AssignNode extends AstNodes {
	String idName;
    String op; //ASSIGN
    AstNodes right;
}
	
class NumberNode extends AstNodes {
    double value;
}

class IdNode extends AstNodes {
    String IdName;
}

