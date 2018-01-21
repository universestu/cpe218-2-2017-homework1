import java.util.Stack;
public class Homework1 {

	public static void main(String[] args) {

		String post = "251-*32*+";
		if(args.length>0)post=args[0];
		tree t = new tree(post);
		t.TreeStack();
		t.inorder(t.treeroot);
		t.infix(t.treeroot);
		t.calculate(t.treeroot);
		System.out.print( " = " + t.sum);
		//  System.out.println(t.sum);


	}




	public static class tree {

		public String postfix;
		public Node treeroot;
		public int sum = 0;

		tree(String postfix){
			this.postfix = postfix;
		}

		public void inorder(Node node){
			if (node == null){
				return ;
			}
			else
				inorder(node.left);
			inorder(node.right);
		}

		public boolean operater(char x){
			if(x == '+'|| x == '-'|| x == '*'|| x == '/'){
				return true;
			}
			else{
				return false;
			}
		}



		public int calculate (Node node){

			if((operater(node.x))){
				switch (node.x){
					case '+': sum = calculate(node.left) + calculate(node.right) ; break;
					case '-': sum = calculate(node.left) - calculate(node.right) ; break;
					case '*': sum = calculate(node.left)  * calculate(node.right) ; break;
					case '/': sum = calculate(node.left)  / calculate(node.right) ; break;

				}
			}
			else{
				return num(node.x);
			}
			return sum;
		}


		public void TreeStack(){
			final Stack<Node> node = new Stack<Node>();
			for (int i = 0; i < postfix.length(); i++){
				char x  = postfix.charAt(i);

				if (operater(x))
				{
					Node rightNode = node.pop();
					Node leftNode = node.pop();
					node.push(new Node(leftNode,x,rightNode));
				}
				else
				{
					node.add(new Node(null, x, null));
				}

			}
			treeroot = node.pop();
		}


		public void infix(Node n){
			System.out.println(n);
		}



		private int num(char num)
		{
			return num - '0';
		}


	}


	public static class Node {
		Node right,left;
		char x;
		Node (Node left,char x ,Node right){
			this.x = x;
			this.left = left;
			this.right = right;
		}
		public String toString() {
			return (right == null && left == null) ? Character.toString(x) : "(" + left.toString()+ x + right.toString() + ")";
		}
	}

}
