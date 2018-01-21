import java.util.Stack;

public class Homework1 {

	public static void main(String[] args) {
		// Begin of arguments input sample
		if (args.length > 0) {
			String input = args[0];
			//String input = "251-*32*+";
			Node root = new Node(input);
			root = infix(root);
			inorder(root);
			System.out.print("=");
			calculator(root);
		}
	}

	public static Node infix(Node rootEmp){
		rootEmp = readStack(rootEmp.getValue());
		return rootEmp;
	}

	public static void inorder(Node n){
		inOrderTree(n,0);
	}

	public static void calculator(Node n){
		System.out.println(calNode(n));
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



	public static Integer calNode(Node n) {
		if (n == null) {
			return 0;
		}
		if(n.left == null && n.right == null){
			return n.getIntValue();
		}
		Integer sumLeft = calNode(n.right);
		Integer sumRight = calNode(n.left);
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



	private static void inOrderTree(Node n, int c) {
		// Print Infix by tree
		if (n.left == null && n.right == null) {
			System.out.print(n.getValue());

		}else {
			// internal node - an operator
			if( c > 0){
			System.out.print("(");
			}
			inOrderTree(n.right,c+1);
			System.out.print(n.getValue());
			inOrderTree(n.left, c+1);
			if(c >0) {
				System.out.print(")");
			}
		}
	}

	/*public static void inorderTravel(Node n){
		if(n == null){
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		Node tmpNode = n;
		while (tmpNode != null){
			stack.push(tmpNode);
			tmpNode = tmpNode.right;
		}

		while (stack.size() > 0){
			tmpNode = stack.pop();
			System.out.print(tmpNode.getValue());
			if (tmpNode.left != null){
				tmpNode = tmpNode.left;
				while (tmpNode != null){
					stack.push(tmpNode);
					tmpNode = tmpNode.right;
				}
			}
		}
	}*/




	/*public static String interPreorder(Node n){
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

	}*/
}
