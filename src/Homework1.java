import java.util.Stack;

public class Homework1 {
	public static Stack<Character> NumberSet=new Stack<Character>();
	public static Node tree;
	public static void main(String[] args) {
		// Begin of arguments input sample
        String input ="251-*32*+";
		if (args.length > 0) {
			 input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}
		}
        for (int i = 0; i <input.length(); i++) {
            NumberSet.push(input.charAt(i));
        }
        tree=new Node(NumberSet.pop());
		Inorder(tree);
        InfixRoot(tree);

	}
	public static Boolean IsNumber(Character s)
	{
		if("0123456789".indexOf(s)!=-1)
		{
			return true;
		}
		return false;
	}
	public static Boolean IsOperator(Character s)
	{
		if("+-*/".indexOf(s)!=-1)
		{
			return true;
		}
		return false;
	}
	public static void Inorder(Node n)
	{
		if(IsOperator(n.Data))
        {
            n.Right=new Node(NumberSet.pop());
            Inorder(n.Right);
            n.left=new Node(NumberSet.pop());
            Inorder(n.left);
        }
	}
	public static int Calculated(Node cal)
	{
		if(IsNumber(cal.Data))
		{
			return Integer.parseInt(cal.Data.toString());
		}else if(IsOperator(cal.Data))
		{
			if(cal.Data=='+')
			{
				return Calculated(cal.left)+Calculated(cal.Right);
			}else if(cal.Data=='-')
			{
				return Calculated(cal.left)-Calculated(cal.Right);
			}else if(cal.Data=='*')
			{
				return Calculated(cal.left)*Calculated(cal.Right);
			}else if(cal.Data=='/')
			{
				return Calculated(cal.left)/Calculated(cal.Right);
			}
		}
		return 0;
	}
	public static void Infix(Node post)
	{
		if(IsNumber(post.Data))
		{
			System.out.print(post.Data);
		}else if(IsOperator(post.Data))
		{
			System.out.print("(");
			Infix(post.left);
			System.out.print(post.Data);
			Infix(post.Right);
			System.out.print(")");
		}
	}
	public static void InfixRoot(Node post)
	{
		if(IsNumber(post.Data))
		{
			System.out.print(post.Data);
		}else if(IsOperator(post.Data))
		{
			Infix(post.left);
			System.out.print(post.Data);
			Infix(post.Right);
		}
		System.out.println("="+Calculated(post));
	}
}
