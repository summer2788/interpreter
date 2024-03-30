import org.antlr.v4.runtime.*;

public class BuildAstVisitor extends ExprBaseVisitor<AstNodes> {

	@Override
	public AstNodes visitProg(ExprParser.ProgContext ctx) {

		ProgNode progNode = new ProgNode();
		
		for(int i=0; i< ctx.getChildCount()-2; i++ ) {
			/*last child of the start symbol(prog) is EOF */
			//Do not visit this child and attempt to convert it to an Expression object.
			
			progNode.addExpression(visit(ctx.getChild(i)));
			//visit method is in Antlr library and it will convert parse tree into expression and recursively do the visit 
		}
		return progNode;
	}

	@Override
	public AstNodes visitInfixExpr(ExprParser.InfixExprContext ctx) {
		InfixNode infixNode = new InfixNode();
		infixNode.left = visit(ctx.expr(0));
		infixNode.right = visit(ctx.expr(1));
		infixNode.op = ctx.getChild(1).getText();  // the operator is in the middle
		switch(infixNode.op) {
    	case "+":
    		infixNode.op = "ADD";
    		break;
    	case "-":
    		infixNode.op = "SUB";
    		break;
    	case "*":
    		infixNode.op = "MUL";
    		break;
    	default:
    		infixNode.op = "DIV";
    		break;
	}
		
        return infixNode;
	}

	@Override
	public AstNodes visitNumberExpr(ExprParser.NumberExprContext ctx) {
		NumberNode numberNode = new NumberNode();
        numberNode.value = Double.parseDouble(ctx.getText());
        return numberNode;
	}

	@Override
	public AstNodes visitParensExpr(ExprParser.ParensExprContext ctx) {
		// Just return the inner expression node directly
	    return visit(ctx.expr());
	}

	@Override
	public AstNodes visitAssignExpr(ExprParser.AssignExprContext ctx) {
		
		AssignNode assignNode = new AssignNode();
	    assignNode.idName = ctx.getChild(0).getText();
	    assignNode.op = "ASSIGN";
	    assignNode.right = visit(ctx.expr());
	    return assignNode;
	}
	
	

	@Override
	public AstNodes visitIdExpr(ExprParser.IdExprContext ctx) {
	    IdNode idNode = new IdNode();
        idNode.IdName = ctx.getText();
        return idNode;
	}

    
   
}
