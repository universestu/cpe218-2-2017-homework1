
package homework1;


import java.util.Stack;


public class Homework1 {
    public static Node idiotTree;
    public static Stack<Character> EX = new Stack<Character>();

	public static void main(String[] args)
        {
                String example = "251-*32*+";
                for(int i = 0; i < example.length(); i++)
                {
                    EX.push(example.charAt(i));
                    //System.out.print(EX);
                }
                idiotTree = new Node(EX.pop());
                infix(idiotTree);
                inorder(idiotTree);
                System.out.print("="+calculate(idiotTree));
	}
        
        public static class Node
        {
            public Character symbol;
            public Node left;
            public Node right;
            Node(char n)
            {
                symbol = n;
            }
        }
        
        public static void infix(Node node)
        {
            if(node.symbol == '+' || node.symbol == '-' || node.symbol == '*' || node.symbol == '/')
            {
                node.right = new Node(EX.pop());
                infix(node.right);
                node.left = new Node(EX.pop());
                infix(node.left);
            }
        }
        
        public static void inorder(Node node)
        {
            if(node !=  null)
            {
                System.out.print("(");
		inorder(node.left);
		System.out.print(node.symbol);
		inorder(node.right);
                System.out.print(")");
            }
        }
        
        public static int calculate(Node node)
        {
            if(null != node.symbol) switch(node.symbol)
            {
                case '+':
                    return calculate(node.left) + calculate(node.right);
                case '-':
                    return calculate(node.left) - calculate(node.right);
                case '*':
                    return calculate(node.left) * calculate(node.right);
                case '/':
                    return calculate(node.left) / calculate(node.right);
                default:
                    return Integer.parseInt(node.symbol.toString());
            }
            else
            {
                return 0;
            }
        }
        
}
