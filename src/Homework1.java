import java.util.Stack;
public class Homework1 {
	static Node tree;
    	static Stack<Character> queStack = new Stack<Character>();

	
	public static void main(String[] args) {
		// Begin of arguments input sample
		if (args.length > 0) {
			String input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}
		}
		// End of arguments input sample
		
		// TODO: Implement your project here
	if(args.length > 0){
            String input = args[0];
            int dataLength = input.length() - 1;
                
        tree = new Node(queStack.pop());
        infix(tree);
        inorder(tree);
        System.out.print(" = " + calculate(tree));
        
        }
}
	
static class Node{
    int data;
    Node left;
    Node right;	
    public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    static void infix(Node n){
        if(n.data == '1' || n.data == '2' ||  n.data == '3' ||  n.data == '4' ||  n.data == '5' || n.data == '6' || n.data == '7' || n.data == '8' || n.data == '9' || n.data == '0'){ 
                
            if (n.left != null && n.right != null) 
            {  
                System.out.print ("(");
            }
                
            infix(n.left);
            System.out.print(n.data);
            infix(n.right);
                
            if (n.left != null && n.right != null) {  
                System.out.print (")");
            }
        }
    }
           
    static void inorder(Node n){
        
        if(n.data == '+' || n.data == '-' || n.data == '*' || n.data == '/')
        {
            inorder(n.left);
            System.out.print(n.data);
            inorder(n.right);
        }
    }
        
    static int calculate(Node n){
        
        if(n.data == '+' || n.data == '-' || n.data == '*' || n.data == '/')
        {
            if(n.data == '+'){
               return calculate(n.left) + calculate(n.right);
            }
            if(n.data == '-'){
              return calculate(n.left) - calculate(n.right);
            }
            if(n.data == '*'){
                return calculate(n.left) * calculate(n.right);
            }
            if(n.data == '/'){
                return calculate(n.left) / calculate(n.right);
            }
        } 
        else 
        {
            return Character.getNumericValue(n.data);
        }
        return 0;
    }
}
