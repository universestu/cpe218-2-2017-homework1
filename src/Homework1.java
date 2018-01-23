import javax.swing.JTree;
import java.util.Stack;

public class Homework1 {
	static public void main(String[] args) {
		// Begin of arguments input sample
		try {
			Node current = new Node(args[0]);
			current = Tostack(current);
			StringBuffer x = new StringBuffer(infix(current));
			x.deleteCharAt(0);
			x.deleteCharAt(x.length() - 1);
			System.out.print(x);
			System.out.println("=" + calculate(current));
			//System.out.print(inorder(current));
		}catch (Exception e){
			System.out.print("Invalid Input Try Again ..");
		}
		// End of arguments input sample
	}

	static public Node Tostack(Node n){
		Stack<Character> stack = new Stack<>();
		for(int i=0 ; i<n.sr.length();i++){
			stack.push(n.sr.charAt(i));
		}
		Node root = new Node(' ');
		n = Maketree(stack,n,root);

		return n;
	}
	static public String infix(Node n){
		if(isOperator(n.ar)){
			return ("("+infix(n.left) + n.ar + infix(n.right)+")");
		}else{
			return (n.ar+"");
		}
	}

	static public String inorder(Node n){
		if(n.left != null && n.right != null){
			return (inorder(n.left) +" "+ n.ar + " " + inorder(n.right));
		}else{
			return (n.ar+"");
		}
	}

	static public int calculate(Node n){
		if(isOperator(n.ar)){
			switch(n.ar){
				case '+': return calculate(n.left)+calculate(n.right);
				case '-': return calculate(n.left)-calculate(n.right);
				case '*': return calculate(n.left)*calculate(n.right);
				case '/': return calculate(n.left)/calculate(n.right);
			}
		}else{
			return n.ar-'0';
		}
		return  n.fl;
	}

	static public Node Maketree(Stack<Character> stack,Node n,Node root){

		Node current = n;
		if(stack.empty()){
			return n;
		}
		if(isOperator(stack.peek())){
			if(root.ar == ' ' ){
				current.ar = stack.pop();
				root.ar = current.ar;
				current.parent = null;
				Maketree(stack,current,root);
			}else{
				if(current.right == null){
					current.right = new Node(stack.pop());
					current.right.parent = current;
					Maketree(stack,current.right,root);
				}else if(current.left == null){
					current.left = new Node(stack.pop());
					current.left.parent = current;
					Maketree(stack,current.left,root);
				}
			}
		}else{
			if(current.right == null){
				current.right = new Node(stack.pop());
				current.right.parent = current;
				Maketree(stack,current,root);
			}else if(current.left == null){
				current.left = new Node(stack.pop());
				current.left.parent = current;
				Maketree(stack,current.parent,root);
			}else{
				current.parent.left = new Node(stack.pop());
				current.parent.left.parent = current.parent;
				Maketree(stack,current.parent.parent,root);
			}
		}
		return  n;
	}

	static public class Node{
		int fl;
		char ar;
		String sr;
		Node right,left,parent;

		public Node(char e) {
			this.ar = e;
		}
		public Node(String k){
			this.sr = k;
		}
	}

	static public boolean isOperator(Character ch){
		switch(ch){
			case '+': return true;
			case '-': return true;
			case '*': return true;
			case '/': return true;
			default: return false;
		}
	}
}

