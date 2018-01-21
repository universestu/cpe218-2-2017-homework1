import java.util.Stack;

public class Homework1 {
	public static node root;
	public static Stack<Character> stack1 = new Stack<Character>();//create char stack
	public static void main(String[] args)
	{
		String input="";
		try {
			input = args[0];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			return ;
		}
		for(int i=0;i<input.length();i++)
		{
			stack1.add(input.charAt(i));
		}
		root = new node(stack1.pop());//root node
		infix(root);//create tree
		inorder(root);//print
		System.out.print("="+calculate(root));//print sum
	}

	public static void inorder(node d){
		if(d.check == '+'){//print node.left operand node.right
			if(d!=root)System.out.print("(");
			inorder(d.left);
			System.out.print("+");
			inorder(d.right);
			if(d!=root)System.out.print(")");
		}
		else if(d.check == '-'){
			if(d!=root)System.out.print("(");
			inorder(d.left);
			System.out.print("-");
			inorder(d.right);
			if(d!=root)System.out.print(")");
		}else if(d.check == '*'){
			if(d!=root)System.out.print("(");
			inorder(d.left);
			System.out.print("*");
			inorder(d.right);
			if(d!=root)System.out.print(")");
		}else if(d.check == '/'){
			if(d!=root)System.out.print("(");
			inorder(d.left);
			System.out.print("/");
			inorder(d.right);
			if(d!=root)System.out.print(")");
		}
		else
		{
			System.out.print(d.check);//print integer
		}
	}

	public static void infix(node b) {
		if(b.check =='+'||b.check == '-'||b.check =='*'||b.check =='/' ){//check operand
			b.right=new node(stack1.pop());//create right node
			infix(b.right);
			b.left=new node(stack1.pop());//create left node
			infix(b.left);
		}
	}

	public static int calculate(node c){
		if(c.check =='+'){
			return calculate(c.left) + calculate(c.right);
		}
		if(c.check =='-'){
			return calculate(c.left) - calculate(c.right);
		}
		if(c.check =='*'){
			return calculate(c.left) * calculate(c.right);
		}
		if(c.check =='/'){
			return calculate(c.left) / calculate(c.right);
		}
		else return Integer.parseInt(c.check.toString());//if not operand change to int
	}
}

class node{
	node left,right;//node left and node right
	Character check;//check a must be char
	node(char a){
		check=a;
	}
}




