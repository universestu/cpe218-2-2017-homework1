
import java.util.Stack;

public class TraversalTree {

    private String postfix;
    public Node root;
    public int sum = 0;


    public TraversalTree(String postfix)
    {
        if (postfix == null) { throw new NullPointerException("The posfix should not be null"); }
        if (postfix.length() == 0)  { throw new IllegalArgumentException("The postfix should not be empty"); }
        this.postfix = postfix;
    }

    public boolean isOperator(char c){
        if (    c == '+' ||
                c == '-' ||
                c == '*' ||
                c == '/'){
            return true;
        }
        return false;
    }

    public void createExpressionTree()
    {
        final Stack<Node> nodes = new Stack<Node>();
        for (int i = 0; i < postfix.length(); i++)
        {
            char ch  = postfix.charAt(i);
//        System.out.println(nodes);
            if (isOperator(ch))
            {
                Node rightNode = nodes.pop();
                Node leftNode = nodes.pop();
                nodes.push(new Node(leftNode, ch, rightNode));
            }
            else if (!Character.isWhitespace(ch))
            {
                nodes.add(new Node(null, ch, null));
            }
        }
        root = nodes.pop();
    }

    public void inorder(Node n){
        if (n == null)
        { return; }
        inorder(n.left);
        inorder(n.right);
    }

    public void infix(Node n){
        System.out.print(n);
    }

    public int calculate(Node n){

        if(isOperator(n.ch)){
            switch(n.ch){
                case '+': sum = calculate(n.left) + calculate(n.right) ; break;
                case '*': sum = calculate(n.left)  * calculate(n.right) ; break;
                case '-': sum = calculate(n.left) - calculate(n.right) ; break;
                case '/': sum = calculate(n.left)  / calculate(n.right) ; break;
                default  : sum = calculate(n.left)  + calculate(n.right) ; break;
            }
        }
        else{
            return toDigit(n.ch);
        }
        return sum;
    }

    private boolean isDigit(char ch)
    {
        return ch >= '0' && ch <= '9';
    }
    private int toDigit(char ch)
    {
        return ch - '0';
    }
}