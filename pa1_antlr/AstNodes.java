
import java.util.ArrayList;
import java.util.List;


class AstNodes {

}

class ProgNode extends AstNodes {
	public List<AstNodes> expressions;
	
	public ProgNode() {
		this.expressions = new ArrayList<>();
		
	} 
	
	public void addExpression(AstNodes e) {
		if(e != null)
			expressions.add(e);
		
	}
}
	
class InfixNode extends AstNodes {
    String op; // e.g. ADD, SUB, MUL, DIV
    AstNodes left, right;
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

