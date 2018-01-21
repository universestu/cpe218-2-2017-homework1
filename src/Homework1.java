import java.util.NoSuchElementException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.JTree;
public class Homework1 {
	public static node tree;
	public static Stack<Character> gg = new Stack<Character>();

	public static void main(String[] args) {
		// Begin of arguments input sample
		/*if (args.length > 0) {
			String input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(51))+(3*2)=14");
			}
		}
		// End of arguments input sample

		// TODO: Implement your project here*/

		//String posfix  = "251-*32*+";
		String posfix = args[0];
		char[] postfix_array = posfix.toCharArray();

		node root = tree(postfix_array);
		System.out.println(infix(root) + "=" + calculate(root));


	}

	public static node tree(char A[]) {

		Stack<node> info = new Stack();
		node head, Y, Z;

		for (int i = 0; i < A.length; i++) {

			if (!EX(A[i])) {

				head = new node(A[i]);
				info.push(head);

			} else {

				head = new node(A[i]);
				Z = info.pop();
				Y = info.pop();

				head.left = new node();
				head.left = Y;
				head.right = new node();
				head.right = Z;

				info.push(head);


			}

		}

		head = info.peek();
		return head;


	}


	public static String infix(node node) {

		StringBuilder infix = new StringBuilder();
		infix = inorder(node);

		infix.deleteCharAt(0);
		infix.deleteCharAt(infix.length() - 1);
		for (int i = 1; i < infix.length() - 1; i++) {

			if (infix.charAt(i - 1) == '(' && !EX(infix.charAt(i)) && infix.charAt(i + 1) == ')') {
				infix.setCharAt(i - 1, ' ');
				infix.setCharAt(i + 1, ' ');
			} else if (infix.charAt(i) == ' ') {

				continue;
			}

		}

		for (int i = 0; i < infix.length(); i++) {

			if (infix.charAt(i) == ' ') {
				infix.deleteCharAt(i);

			}

		}


		return infix.toString();
	}

	public static StringBuilder inorder(node node) {

		StringBuilder infix = new StringBuilder();

		subinorder(node, infix);

		return infix;

	}

	public static void subinorder(node node, StringBuilder infix) {

		if (node != null) {
			infix.append("(");
			subinorder(node.left, infix);
			infix.append(node.b);
			subinorder(node.right, infix);
			infix.append(")");
		}

	}


	public static boolean EX(char x) {

		if (x == '+' || x == '-' || x == '*' || x == '/') {

			return true;

		}

			return false;

		}



	public static boolean ishasoperater(String text) {

		for (int i = 0; i < text.length(); i++) {

			if (EX(text.charAt(i))) {
				return true;
			}

		}

		return false;
	}

	public static int calculate(node node) {


		if (node.b == '+') {

			return calculate(node.left) + calculate(node.right);

		} else if (node.b == '-') {
			return calculate(node.left) - calculate(node.right);

		} else if (node.b == '*') {

			return calculate(node.left) * calculate(node.right);

		} else if (node.b == '/') {

			return calculate(node.left) / calculate(node.right);

		} else return Integer.parseInt((String.valueOf(node.b)));


	}

}

