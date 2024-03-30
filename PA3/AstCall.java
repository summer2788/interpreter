

class AstCall {

    public void Call(AstNodes node, int depth) {
        if (node == null) {
            return;
        }
        
        printIndent(depth);
        
        if (node instanceof FunctionDeclNode) {
            FunctionDeclNode funcDecl = (FunctionDeclNode) node;
            System.out.println("DECL");
            printIndent(depth+1);
            System.out.println(funcDecl.functionName);
            for (String param : funcDecl.parameters) {
                printIndent(depth + 1);
                System.out.println(param);
            }
            Call(funcDecl.body, depth + 1);
            
        } else if (node instanceof FunctionCallNode) {
            FunctionCallNode funcCall = (FunctionCallNode) node;
            System.out.println("CALL");
            printIndent(depth+1);
            System.out.println(funcCall.functionName);
            for (AstNodes arg : funcCall.arguments) {
                Call(arg, depth + 1);
            }
            
        } else if (node instanceof LetNode) {
            LetNode letNode = (LetNode) node;
            System.out.println("LETIN");
            printIndent(depth+1);
            System.out.println(letNode.variableName);
            Call(letNode.assignedExpr, depth + 1);
            Call(letNode.inExpr, depth + 1);
            
        } else if (node instanceof NegNode) {
            NegNode negNode = (NegNode) node;
            System.out.println(negNode.op);
            Call(negNode.expr, depth + 1);
            
        } else if (node instanceof InfixNode) {
            InfixNode infixNode = (InfixNode) node;
            System.out.println(infixNode.op);
            Call(infixNode.left, depth + 1);
            Call(infixNode.right, depth + 1);
            
        } else if (node instanceof NumberNode) {
            NumberNode numberNode = (NumberNode) node;
            System.out.println(numberNode.value);
            
        } else if (node instanceof IdNode) {
            IdNode idNode = (IdNode) node;
            System.out.println(idNode.IdName);
            
        } else if (node instanceof AssignNode) {
            AssignNode assignNode = (AssignNode) node;
            System.out.println(assignNode.op);
            printIndent(depth);
            System.out.println(assignNode.idName);
            Call(assignNode.right, depth + 1);
            
        } else if (node instanceof ProgNode) {
            ProgNode progNode = (ProgNode) node;
            for (AstNodes n : progNode.expressions) {
                Call(n, 0);
            }
        }
    }
    
    private void printIndent(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("      ");
        }
    }
}
