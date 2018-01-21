import java.util.Stack;

public class Homework1 {

	public static class Node {
		Node Right,Left;
		char T_ree;

		Node(char input) {
			T_ree = input;
		}

	}

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
        public static  Node Tonmai;
		public static  Stack<Charcter> Tree = new Stack<Character>();

		String profix = args[0];
		for (int i = 0; i < profix.length(); i++){
		    Tree.add(Profix.charAt(i));
        }

        Tonmai = new Node(Tree.pop());

		infix(Tonmai);
		inorder(Tonmai);
		System.out.print("="+calculate(Tonmai))


        public static void infix(Node A){
		    if(A.Tree == '+' || A.Tree == '-' || A.Tree == '*' || A.Tree == '/'){
		        A.Right = new Node(Tree.pop());
		        infix(A.Right);
		        A.Left =new Node(Tree.pop());
		        infix(A.Left);
            }
        }
        public static void inorder(Node B){
		    if(A.Tree == '+' || A.Tree == '-' || A.Tree == '*' || A.Tree == '/'){
		        if(B != Tonmai){
		           System.out.print("("));
		        }
		        inorder(B.Left);
		        System.out.print(B.T_ree);
		        inorder(B.Right);
		        if(B != Tonmai){
		            System.out.print(")");
                }
            }else {
		        if(B != Tonmai){
		            System.out.print(B.T_ree);
                }
            }
        }

    public static int calculate(Node ccl){
            if(ccl == null){return 0;}
            if(ccl.Tree == '+'){return calculate(ccl.Left) + calculate(ccl.Right);}
            if (ccl.Tree == '-'){return calculate(ccl.Left) - calculate(ccl.Right);}
            if (ccl.Tree == '*'){return calculate(ccl.Left) * calculate(ccl.Right);}
            if (ccl.Tree == '/'){return calculate(ccl.Left) / calculate(ccl.Right);}
            else return Integer.parseInt(ccl.Tree.toString());
        }
}
