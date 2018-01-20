import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class Homework1 {
	public static node Tree;
	public static Stack <Character> st = new Stack<Character>();
	public static Boolean IsNumber(Character character)
	{
		if("0123456789".indexOf(character.toString())!=-1)
		{
			return true;
		}
		return false;
	}

	public static Boolean Isoperand(Character character)
	{
		if("+-*/".indexOf(character.toString())!=-1)
		{
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// Begin of arguments input sample
		String input="251-*32*+";
		if (args.length > 0) {
			input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}
		}
		for (int i = 0; i <input.length() ; i++) {
			st.add(input.charAt(i));
		}
		Tree=new node(st.pop());
		infix(Tree);
		inorder(Tree);

		System.out.println("="+calculate(Tree));
	}



	public static void  infix(node n) {
		if (Isoperand(n.Keyy)){
			n.right = new node(st.pop());
			infix(n.right);
			n.left = new node(st.pop());
			infix(n.left);
		}


		// End of arguments input sample

		// TODO: Implement your project here
	}

	public  static void inorder(node n) {
		if (Isoperand(n.Keyy)) {
			if (n != Tree)System.out.print("(");
			inorder(n.left);
			System.out.print(n.Keyy);
			inorder(n.right);
			if(n != Tree) System.out.print(")");
		}
		else
		{
			System.out.print(n.Keyy);
		}
	}
	public static int calculate(node n){
		if (Isoperand(n.Keyy)){
			if(n.Keyy == '+'){
				return calculate(n.left)+calculate(n.right);
			}
			else if (n.Keyy == '-'){
				return calculate(n.left)-calculate(n.right);
			}
			else if(n.Keyy == '*'){
				return calculate(n.left)*calculate(n.right);
			}
			else if(n.Keyy == '/'){
				return calculate(n.left)/calculate(n.right);
			}
		}
		else if(IsNumber(n.Keyy)){
			return Integer.parseInt(n.Keyy.toString()) ;
		}

		return 0;

	}
}
