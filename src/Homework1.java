import java.util.Stack;

public class Homework1 {
	public static Stack<Character> Bomb = new Stack<Character>();
	public static node tree;
	public static void main(String[] args)
	{
// Begin of arguments input sample
//		if (args.length > 0) {
//			String input = args[0];
//			if (input.equalsIgnoreCase("251-*32*+")) {
//				System.out.println("(2*(5-1))+(3*2)=14");
//			}
//		}
		String input ="251-*32*+";
		for(int i=0;i<input.length();i++)
		{
			Bomb.add(input.charAt(i));
		}
		tree = new node(Bomb.pop());
		infix(tree);
		calculate(tree);
		inorder(tree);
		System.out.println("="+calculate(tree));
		// End of arguments input sample
		// TODO: Implement your project here
	}

	public static void inorder(node d){
		if(d.nop == '+'){
			if(d!=tree)System.out.print("(");
			//check "()" if d is root node
			inorder(d.left);
			System.out.print("+");
			inorder(d.right);
			if(d!=tree)System.out.print(")");
		}
		else if(d.nop == '-'){
			if(d!=tree)System.out.print("(");
			inorder(d.left);
			System.out.print("-");
			inorder(d.right);
			if(d!=tree)System.out.print(")");
		}else if(d.nop == '*'){
			if(d!=tree)System.out.print("(");
			inorder(d.left);
			System.out.print("*");
			inorder(d.right);
			if(d!=tree)System.out.print(")");
		}else if(d.nop == '/'){
			if(d!=tree)System.out.print("(");
			inorder(d.left);
			System.out.print("/");
			inorder(d.right);
			if(d!=tree)System.out.print(")");
		}
		else
		{
			System.out.print(d.nop);
		}
	}

	public static void infix(node b) {
		//add to tree
		if(b.nop =='+'||b.nop == '-'||b.nop =='*'||b.nop =='/' ){
			b.right=new node(Bomb.pop());
			infix(b.right);
			b.left=new node(Bomb.pop());
			infix(b.left);
		}
	}

	public static int calculate(node c){
		if(c.nop =='+'){
			return calculate(c.left) + calculate(c.right);
		}

		if(c.nop =='-'){
			return calculate(c.left) - calculate(c.right);
		}

		if(c.nop =='*'){
			return calculate(c.left) * calculate(c.right);
		}

		if(c.nop =='/'){
			return calculate(c.left) / calculate(c.right);
		}
		else return Integer.parseInt(c.nop.toString()); // change to integer
	}
}

class node {
	Character nop;
	node(char a)
	//check input
	{
		nop=a;
	}
	node left;
	node right;
}




