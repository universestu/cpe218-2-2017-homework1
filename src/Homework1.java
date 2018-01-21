import java.util.Scanner;
import java.util.Stack;


class Node{
    Node left, right ;
    char c;
    Node(char c){
        this.c = c;
        left = null;
        right = null;
        
    }
    
    
}

public class Homework1 {

	public static void main(String[] args) {
		/*// Begin of arguments input sample
		if (args.length > 0) {
			String input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}
		}
		//End of arguments input sample */
		
		// TODO: Implement your project here
                System.out.print("Input: ");
                
                Scanner input = new Scanner(System.in);
                Homework1 boom = new Homework1();
                String postfix = input.nextLine();
                char[] c = postfix.replace(" ", "").toCharArray();
                Node root = boom.tree(c);
                
                System.out.print("Output: ");
                boom.infix(root);
                System.out.print(" = ");
              System.out.println(calculate(root));
	}
        
        Node tree(char[] postfix){
            Stack<Node> st = new Stack();
            Node r ,t1 ,t2 ;
            
           
            
            for(int i=0;i<postfix.length;i++){
                if(!isOperator(postfix[i])){
                    r = new Node(postfix[i]);
                    st.push(r);
                }else{
                    r = new Node(postfix[i]);
                    t1 = st.pop();
                    t2 = st.pop();
                        
                    r.right = t1;
                    r.left = t2;
                    
                  

                    st.push(r);
                    }
                }
            r = st.peek();
            st.pop();
            
            return r;
        }
        
        public static void infix(Node n){
            if (n != null) {
                if (n.left != null && n.right != null) {  
                    System.out.print ("(");
                }
                infix(n.left);
                System.out.print(n.c);
                infix(n.right);
                if (n.left != null && n.right != null) {  
                    System.out.print (")");
                }
            }
         }
        
        public static void inorder(Node n){
            if (n != null) {
                inorder(n.left);
            
                System.out.print(n.c);
            
                inorder(n.right);
            }
        }
        
        public static double calculate(Node n){
            
            if (n.left == null && n.right == null)
                return n.c - '0';
            else{
                double result = 0;
                double left = calculate(n.left);
                double right = calculate(n.right);
                char operator = n.c;
                

                switch (operator){
                    
                    case '+' : result = left + right; break;
                    case '-' : result = left - right; break;
                    case '*' : result = left * right; break;
                    case '/' : result = left / right; break;
                    default  : result = left + right; break;
                }
                return result;
            }   
        }
                
        public static boolean isOperator(char c){
            return c=='+' || c=='-' || c=='*' || c=='/';
        }
        
        public static Node findMin(Node node){
            Node min = node;
            while(min.left != null){
                min = min.left;
            }
            return min;
        }
        
        public static Node findMax(Node node){
            Node max = node;
            while(max.right != null){
                max = max.right;
            }
            return max;
        
    }
}
