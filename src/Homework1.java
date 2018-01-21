import java.util.Stack;
public class Homework1 {
	public static Node completeTree;
	public static Stack<Node> text = new Stack<Node>();
	public static void main(String[] args) {
		// Begin of arguments input sample
		/*String posfix = "0";
		try{
			posfix = args[0] ;
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("No args. !");
			return ;
		}*/
		/*if (args.length > 0) {
			String input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				//System.out.println("(2*(5-1))+(3*2)=14");
			}
		}*/
		// End of arguments input sample

		// TODO: Implement your project here
		String posfix = args[0];
		//String posfix  = "251-*32*+";
		char [] postfix_array = posfix.toCharArray();
		completeTree = createTree(postfix_array);
		Infix(completeTree);
		System.out.println("="+calculate(completeTree));
	}


	public static boolean is_operater(char c) {
		return c== '+' || c=='-' || c=='*' || c=='/';
	}

	public static Node createTree(char posfix_array[]) {
		Stack<Node> question = new Stack<Node>();
		for (int i = 0; i < posfix_array.length; i++) {
			char ch = posfix_array[i];
			if (is_operater(ch)){
				Node Noderight = question.pop();
				Node Nodeleft = question.pop();
				question.push(new Node(Nodeleft,ch,Noderight));
			}
			else {
				question.push(new Node(null,ch,null));
			}
		}
		return question.peek();
	}

	public static int calculate(Node n) {
		int sum = 0;
		int l,r;
		if(n.left != null) {
			l = calculate(n.left);
		}else {
			l = 0;
		}
		if(n.right != null) {
			r = calculate(n.right);
		}else {
			r = 0;
		}
		if(is_operater(n.op)){
			switch(n.op){
				case '+': sum = l+r; break;
				case '*': sum = l*r; break;
				case '-': sum = l-r; break;
				case '/': sum = l/r; break;
			}
		}
		else {
			return Integer.parseInt(String.valueOf(n.op));
		}
		return sum;
	}

	public static void Infix(Node n) {
		if (n.op == '+' || n.op == '-'|| n.op == '*'|| n.op == '/') {
			if(n!=completeTree) {
				System.out.print("(");
			}
			Infix(n.left);
			System.out.print(n.op);
			Infix(n.right);
			if(n!=completeTree) {
				System.out.print(")");
			}
		}
		else {
			System.out.print(n.op);
		}
	}

	public static void InOrder(Node n){
		if (n.op == '+' || n.op == '-'|| n.op == '*'|| n.op == '/') {
			InOrder(n.left);
			System.out.print(n.op);
			InOrder(n.right);
		}
		else {
			System.out.print(n.op);
		}
	}
}
