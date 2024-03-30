

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.tree.ParseTree;


public class BuildAstVisitor extends ExprBaseVisitor<AstNodes> {
	
	private final Map<String, FunctionDeclNode> functions = new HashMap<>();
    private final Set<String> variables = new HashSet<>();

	@Override
	public AstNodes visitProg(ExprParser.ProgContext ctx) {

		ProgNode progNode = new ProgNode();
		int max= ctx.getChildCount()-2;
		for(int i=0; i< max; i++ ) {
			
			 // Check the type of the context and handle accordingly
            if (ctx.getChild(i) instanceof ExprParser.Decl_listContext) {
                // Visit each decl in the decl_list and add to expressions
				ExprParser.Decl_listContext declListCtx = (ExprParser.Decl_listContext) ctx.getChild(i);
                declListCtx.decl().forEach(declCtx -> progNode.addExpression(visit(declCtx)));
            } else if (ctx.getChild(i) instanceof ExprParser.ExprContext) {
                // It's a single expression
				ExprParser.ExprContext exprCtx = (ExprParser.ExprContext) ctx.getChild(i);
                progNode.addExpression(visit(exprCtx));
            }
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
	public AstNodes visitFunctionDecl(ExprParser.FunctionDeclContext ctx) {
		String functionName = ctx.ID().getText(); // First ID is the function name
		List<String> parameters = new ArrayList<>();
		if (ctx.var_list() != null) {
            parameters = ctx.var_list().ID()
                    .stream().map(ParseTree::getText)
                    .collect(Collectors.toList());
        }
		 AstNodes body = visit(ctx.expr());
		 return new FunctionDeclNode(functionName, parameters, body);
	
	}

	@Override
	public AstNodes visitSimpleFunctionDecl(ExprParser.SimpleFunctionDeclContext ctx) {
		String functionName = ctx.ID().getText();
//		System.out.print(functionName);
		AstNodes body = visit(ctx.expr());
		return new FunctionDeclNode(functionName, new ArrayList<>(), body);
		
	}

	@Override
	public AstNodes visitFunctionCallNoArg(ExprParser.FunctionCallNoArgContext ctx) {
		return new FunctionCallNode(ctx.ID().getText(), new ArrayList<>());
	}

	@Override
	public AstNodes visitFunctionCall(ExprParser.FunctionCallContext ctx) {
		String functionName = ctx.ID().getText();
		List<AstNodes> arguments = ctx.expr_list().expr()
                .stream().map(this::visit)
                .collect(Collectors.toList());
		return new FunctionCallNode(functionName, arguments);
		
	}

	@Override
	public AstNodes visitNegationExpr(ExprParser.NegationExprContext ctx) {
		NegNode negNode = new NegNode();
		negNode.op = "NEGATE";
		negNode.expr = visit(ctx.expr());
		return negNode;
	
	}

	
	@Override
	public AstNodes visitLetExpr(ExprParser.LetExprContext ctx) {
		String variableName = ctx.ID().getText();
		AstNodes assignedExpr = visit(ctx.expr(0));
		AstNodes inExpr = visit(ctx.expr(1));	
		return new LetNode(variableName, assignedExpr, inExpr);
		
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
