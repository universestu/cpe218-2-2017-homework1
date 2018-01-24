import java.text.DecimalFormat;
import java.util.Stack;

public class Homework1 {
	static Stack st = new Stack();

	public static void main(String[] args) {
		if (args.length > 0) {

			String input = args[0];

			int i = -1, n = input.length();
			float ans;
			Node node, root = null;

			while (++i < n) {
				node = new Node(input.charAt(i));
				infix(node);
				root = node;
			}
			inorder(root);
			System.out.print('=');
			ans = calculate(root);
			if (ans == (int) ans) System.out.println((int) ans);
			else System.out.println(ans);
		}
	} //end main

	public static void infix(Node n) {

		if(Character.isDigit(n.x))
			st.push(n);
		else {
			n.right = (Node)st.pop();
			n.left = (Node)st.pop();
			st.push(n);
		}
	} //end infix

	public static void inorder(Node n) {
	    if(!Character.isDigit(n.x) && n!=st.peek()) System.out.print('(');

		if(n.left != null) inorder(n.left);
		System.out.print(n.x);
		if(n.right != null) inorder(n.right);

        if(!Character.isDigit(n.x) && n!=st.peek()) System.out.print(')');
	} //end inorder

	public static float calculate(Node n) {
		switch(n.x) {
            case '+' : return calculate(n.left)+calculate(n.right);
            case '-' : return calculate(n.left)-calculate(n.right);
            case '*' : return calculate(n.left)*calculate(n.right);
            case '/' : return calculate(n.left)/calculate(n.right);
            default: return Character.getNumericValue(n.x);
		}
	} //end calculate
}
