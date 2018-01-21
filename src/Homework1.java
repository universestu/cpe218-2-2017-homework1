import java.sql.SQLType;

public class Homework1 {

	public static String word="";

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
		if(args.length != 0 ) {
			word = args[0];
			Node node = new Node();
			System.out.println(infix(node));
		}


	}

	private static boolean isOperator(char o){
		if(o == '+' || o == '-' || o == '*' || o =='/' || o == '^')
			return true;
		return false;
	}

	public static Node infix(Node n) {
		Node tmp = n;
		for(int i = 0;i < word.length() ; i++) {
			Node parent = new Node();
			parent.value_node = word.charAt(i);
			if(isOperator(parent.value_node)) { //node is Operator
				if(tmp == null) {//case wrong syntax
				}
				else {//collect Syntax
					if(isOperator(tmp.left.value_node)) {
						parent.left = tmp.left.left;
						tmp.left.left = null;
						parent.right = tmp;
						tmp = parent;
					}
					else {
						parent.left = tmp.left;
						tmp.left = null;
						parent.right = tmp;
						tmp = parent;
					}
				}
			} else { //node isn't Operator
				if(tmp != null) { //tmp is valid
					parent.left = tmp;
					tmp = parent;
				}
				else { //tmp is invalid
					tmp = parent;
				}
			}
		}
		return tmp;
	}

	public static String inorder (Node n) {
		String result ="";
		Node tmp = n;
		while (tmp.left != null) {
			String temp = "(" + tmp.left;
		}
		return result;
	}
}
