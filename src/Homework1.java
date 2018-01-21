import java.util.Stack;

public class Homework1 {

	public static void main(String[] args) {
		// Begin of arguments input sample
		if (args.length > 0) {
			String input = args[0];
			input = "251-*32*+";
			/*if (input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}*/


		}
		String input = "251-*32*+";
		Node root = readStack(input);
		//infix(root);
		//System.out.println("\n>> "+input);
		//preorder(root);
		//System.out.println("\n"+interPreorder(root));
		System.out.println(calculator(root));

		// End of arguments input sample
		
		// TODO: Implement your project here

	}
	private static Node readStack(String p){
		Node root = new Node("0");
		Stack<Node> stack  = new Stack<Node>();
		for (int i = 0; i < p.length(); i++ ){
			Character nowCh = p.charAt(i);
			//System.out.println(p.charAt(i));
			//System.out.println(isOperand(p.charAt(i)));
			if(!isOperand(nowCh)){
				stack.push(new Node(nowCh.toString()));
			}else{
				Node tmp = new Node(nowCh.toString());
				tmp.left = stack.pop();
				tmp.right = stack.pop();
				stack.push(tmp);
			}

		}


		return stack.peek();
	}

	public static Integer calculator(Node n) {
		if (n == null) {
			return 0;
		}
		if(n.left == null && n.right == null){
			return n.getIntValue();
		}
		Integer sumLeft = calculator(n.right);
		Integer sumRight = calculator(n.left);
		Integer sum = 0;


		if(n.getValue().equals("+")){
			sum = sumLeft + sumRight;
		}else if(n.getValue().equals("-")){
			sum = sumLeft - sumRight;
		}else if(n.getValue().equals("*")){
			sum = sumLeft * sumRight;
		}else if(n.getValue().equals("/")){
			sum = sumLeft / sumRight;
		}
		return sum;
	}

	private static boolean isOperand(Character op){
		return op == '+' || op == '-' || op == '*' || op =='/';
	}

	public static void infix(Node n){
		if(n != null){
			infix(n.right);
			System.out.print(n.getValue());
			if(n.right == null){
				System.out.print(")");
			}

			infix(n.left);
			if(n.left == null){
				System.out.print("(");
			}
		}

	}



	public static void preorder(Node n){
		//System.out.println("PreOrder");
		if(n != null){
			System.out.print(n.getValue());
			preorder(n.left);
			preorder(n.right);
		}
	}

	public static String interPreorder(Node n){
		if(n != null){
			String tmpString = "";

			Stack<Node> ns = new Stack<Node>();
			ns.push(n);

			while (!ns.empty()){
				Node mn = ns.peek();
				tmpString += mn.getValue();
				ns.pop();
				if (mn.right != null){
					ns.push(mn.right);
				}
				if (mn.left != null){
					ns.push(mn.left);
				}
			}

			return new StringBuilder(tmpString).reverse().toString();
		}return "";

	}
}
