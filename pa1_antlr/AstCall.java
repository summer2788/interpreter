
class AstCall {

    public void Call(AstNodes node, int depth) {
        if (node == null) {
            return;
        }
        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        
        if (node instanceof InfixNode) {
            InfixNode infixNode = (InfixNode) node;
            System.out.println(infixNode.op);
            Call(infixNode.left, depth + 1);
            Call(infixNode.right, depth + 1);
            
        } else if (node instanceof NumberNode) {
            NumberNode numberNode = (NumberNode) node;
            System.out.println(numberNode.value);
      
            
        }else if (node instanceof IdNode) {
        	IdNode idNode = (IdNode) node;
            System.out.println(idNode.IdName);
     
        } 
        else if (node instanceof AssignNode) {
            AssignNode assignNode = (AssignNode) node;
            System.out.println(assignNode.op);
            IdNode idNode = new IdNode();
            idNode.IdName=assignNode.idName;
            Call(idNode, depth + 1);
            Call(assignNode.right, depth + 1);
        
        } else if (node instanceof ProgNode) {
            ProgNode progNode = (ProgNode) node;
            for (AstNodes n : progNode.expressions) {
                Call(n, 0);
            }
        }
    }
}
