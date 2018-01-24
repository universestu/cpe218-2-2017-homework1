import java.util.Stack;

public class Homework1 {

	public static Node bitree;
	public static Stack<Character> numope = new Stack<Character>();

	public static void main(String[] args) {
		// Begin of arguments input sample
	//	if (args.length > 0) {
	//		String input = args[0];
//			if (input.equalsIgnoreCase("251-*32*+")) {
//				System.out.println("(2*(5-1))+(3*2)=14");
//			}
//		}
		// End of arguments input sample
		
		// TODO: Implement your project here

		String profix = args[0];
		for(int i=0;i<profix.length();i++)
		{
			numope.add(profix.charAt(i));
		}
		bitree = new Node(numope.pop());

		infix(bitree);
		inorder(bitree);
		System.out.println("="+calculate(bitree));
	}

	public static void infix(Node z1) {
		if(z1.num_ope == '+' || z1.num_ope == '-' || z1.num_ope == '*' || z1.num_ope == '/') {
			z1.right = new Node(numope.pop());
			infix(z1.right);
			z1.left = new Node(numope.pop());
			infix(z1.left);
		}
	}

	public static void inorder(Node z2) {
		if(z2.num_ope =='+' || z2.num_ope =='-' || z2.num_ope =='*' || z2.num_ope == '/') {
			if(z2 != bitree) { System.out.print("(");}

			inorder(z2.left);
			System.out.print(z2.num_ope);
			inorder(z2.right);

			if(z2 != bitree) {System.out.print(")");}
		}else {
			if(z2 != bitree) {
				System.out.print(z2.num_ope);
			}
		}
	}


	public static int calculate(Node z3){
		if(z3.num_ope =='+' ) {
			return calculate(z3.left) + calculate(z3.right);}
		if(z3.num_ope == '-') {
			return calculate(z3.left) - calculate(z3.right);}
		if(z3.num_ope == '*') {
			return calculate(z3.left) * calculate(z3.right);}
		if(z3.num_ope == '/') {
			return calculate(z3.left) / calculate(z3.right);}

		else return Integer.parseInt(z3.num_ope.toString());
	}

}
