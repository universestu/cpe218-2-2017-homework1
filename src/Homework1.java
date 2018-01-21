import java.util.Stack ;

public class Homework1 {
	static Stack st = new Stack();
	static Node root;

	public static void main(String[] args) {
		if (args.length > 0) {
			String input = args[0];
			for(int i=0;i<input.length();i++){
				Node node = new Node(input.charAt(i));
				infix(node);
				root = node;
			}
			inorder(root);
			System.out.println("="+calculate(root));
		}
	}

	public static void infix(Node n){
		if(n.Operator()) {
			n.right = (Node)st.pop();
			n.left = (Node)st.pop();
			st.push(n);
		} else {
			st.push(n);
		}
	}
	public static void inorder(Node n){
		if(n != root && n.Operator()) System.out.print('(');
		if(n.left != null) inorder(n.left);
		System.out.print(n.hua);
		if(n.right != null) inorder(n.right);
		if(n != root && n.Operator()) System.out.print(')');
	}
	public static int calculate(Node n){
			int result;
			switch (n.hua) {
				case '+':
					result = calculate(n.left)+calculate(n.right);
					break;
				case '-':
					result = calculate(n.left)-calculate(n.right);
					break;
				case '*':
					result = calculate(n.left)*calculate(n.right);
					break;
				case '/':
					result = calculate(n.left)/calculate(n.right);
					break;
				default:
					result = n.toDigit(n.hua);
					break;
			}
			return result;
		}
}