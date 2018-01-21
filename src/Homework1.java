import java.util.Stack;

public class Homework1 {
	public static class Tree
	{
		public Tree left;
		public Tree right;
		public Character key;
		public Tree(Character n)
		{
			key=n;
		}
	}
	public static Tree trees;
	public static Stack<Character> popy=new Stack<Character>();
	public static void main(String[] args) {
		// Begin of arguments input sample
		String input="251-*32*+";
		if (args.length > 0) {
			 input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}
		}
		for (int i = 0; i < input.length(); i++) {
			popy.add(input.charAt(i));
		}
		trees=new Tree(popy.pop());
		infix(trees);
		inOrder(trees);
		System.out.println("="+calculate(trees));
		// TODO: Implement your project here

	}
	public static void inOrder(Tree n)
	{
		if(n.key=='+'||n.key=='-'||n.key=='*'||n.key=='/')
		{
			if(n!=trees) System.out.print("(");
			inOrder(n.left);
			System.out.print(n.key);
			inOrder(n.right);
			if(n!=trees) System.out.print(")");
		}else
		{
			System.out.print(n.key);
		}
	}
	public static void infix(Tree n)
	{
		if(n.key=='+'||n.key=='-'||n.key=='*'||n.key=='/')
		{
			n.right=new Tree(popy.pop());
			infix(n.right);
			n.left=new Tree(popy.pop());
			infix(n.left);
		}
	}
	public static int calculate(Tree n)
	{
		if(n.key=='+')return calculate(n.left)+calculate(n.right);
		else if(n.key=='-')return calculate(n.left)-calculate(n.right);
		else if(n.key=='*')return calculate(n.left)*calculate(n.right);
		else if(n.key=='/')return calculate(n.left)/calculate(n.right);
		else return Integer.parseInt(n.key.toString());
	}
}
