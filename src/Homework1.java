import java.util.Stack;

public class Homework1 {
	public static node tree ;
	public static Stack<Character> memo = new Stack<Character>();
	public static void main(String[] args) {

		String info = "251-*32*+";
		for (int i = 0; i < info.length(); i++) {
			memo.add(info.charAt(i));
		}
		tree = new node(memo.pop());
		infix(tree);
		InOrder(tree);
		System.out.println("=" + Calculate(tree));
	}

	public static void infix(node x) {
		if (x.from == '+' || x.from == '-' || x.from == '*' || x.from == '/') {
			x.right = new node(memo.pop());
			infix(x.right);
			x.left = new node(memo.pop());
			infix(x.left);
		}
	}

		public static void InOrder (node y) {

			if (y.from == '+') {
				if (y != tree) System.out.print("(");
				InOrder(y.left);
				System.out.print('+');
				InOrder(y.right);

				if (y != tree) System.out.print(")");
			} else if (y.from == '-') {
				if (y != tree) System.out.print("(");
				InOrder(y.left);
				System.out.print('-');
				InOrder(y.right);

				if (y != tree) System.out.print(")");
			} else if (y.from == '*') {
				if (y != tree) System.out.print("(");
				InOrder(y.left);
				System.out.print('*');
				InOrder(y.right);

				if (y != tree) System.out.print(")");
			} else if (y.from == '/') {
				if (y != tree) System.out.print("(");
				InOrder(y.left);
				System.out.print('/');
				InOrder(y.right);

				if (y != tree) System.out.print(")");
			} else {
				System.out.print(y.from);

			}
		}
			public static int Calculate (node x){
				if (x.from == '+')
				{
					return Calculate(x.left) + Calculate(x.right);
				}
				else if (x.from == '-')
				{
					return Calculate(x.left) - Calculate(x.right);
				}
				else if (x.from == '*')
				{
					return Calculate(x.left) * Calculate(x.right);
				}
				else if (x.from == '/')
				{
					return Calculate(x.left) / Calculate(x.right);
				}
				else return Integer.parseInt(x.from.toString());
			}
		}


