import javax.swing.JTree;
import java.util.Stack;


public class Homework1 {
	static String[] Arr ;
	static public void main(String[] args) {

		Node current = new Node(args[0]);
		Arr = current.str.split("");
		String infixOperand = inorder(infix(current));
		System.out.print(infixOperand.substring(1, infixOperand.length()-1));
		System.out.print("=" + calculate(infix(current)));

	}

	static public Node infix(Node n){
		Node temp1, temp2, temp3;
		Stack stack = new Stack();
		for(int i=0;i<n.str.length(); i++) {
			char c = n.str.charAt(i);
			if(isOperator(c)) {
				temp1 = new Node(c);
				temp2 = (Node) stack.pop();
				temp3 = (Node) stack.pop();
				temp1.right_Node = temp2;
				temp1.left_Node = temp3;
				stack.push(temp1);
			} else {
				temp1 = new Node(c);
				stack.push(temp1);
			}
		}
		return (Node) stack.pop();
	}

	static public String inorder(Node n){
		if(isOperator(n.chr)){
			return "(" + (inorder(n.left_Node) + n.chr + inorder(n.right_Node)) + ")";
		}else{
			return (n.chr+"");
		}
	}

	static public int calculate(Node n){
		if(isOperator(n.chr)) {
			if (n.chr == '+') {
				return calculate(n.left_Node) + calculate(n.right_Node);
			}else if (n.chr == '-') {
				return calculate(n.left_Node) - calculate(n.right_Node);
			}else if (n.chr == '*') {
				return calculate(n.left_Node) * calculate(n.right_Node);
			}else if (n.chr == '/') {
				return calculate(n.left_Node) / calculate(n.right_Node);
			}
		}
		return  n.chr - '0';
	}

	static public class Node{
		char chr;
		String str;
		Node right_Node,left_Node;

		public Node(char e) {
			this.chr = e;
		}
		public Node(String f) {
			this.str = f;
		}
	}

	static public boolean isOperator(char x) {
		if (x == '+') {
			return true;
		} else if (x == '-') {
			return true;
		} else if (x == '*') {
			return true;
		} else if (x == '/') {
			return true;
		} else return false;
	}

}