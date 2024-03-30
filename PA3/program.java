import java.io.IOException;


	
import org.antlr.v4.runtime.*;


public class program {

    public static void main(String[] args) throws IOException {
                
        // Get Lexer
        ExprLexer lexer = new ExprLexer(CharStreams.fromStream(System.in));
        
        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // Pass tokens to parser
        ExprParser parser = new ExprParser(tokens);
        
        // Make AST from prog and print the tree
        ExprParser.ProgContext ctx = parser.prog();
        ProgNode AST = (ProgNode)new BuildAstVisitor().visitProg(ctx);
    	//semantic error detection
        Evaluate Evaluator1 = new Evaluate();
        AST.expressions.forEach(node -> Evaluator1.evaluate(node));
        if (!Evaluator1.semanticErrors.isEmpty()) {
            Evaluator1.semanticErrors.forEach(System.out::println);
            return;  // Terminate if there are semantic errors
        }
        
        AST.expressions.forEach(node -> new AstCall().Call(node, 0));
        // Evaluate AST result
        Evaluate Evaluator2 = new Evaluate();
        AST.expressions.forEach(node -> System.out.println(Evaluator2.evaluate(node)));
    }
}
