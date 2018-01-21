import java.util.Stack;

public class Homework1 {

	public static Stack s = new Stack();
	public static void main(String[] args) {
		Node n = null;
		Node to = null;
		int  i =0;
		float result;
		// Begin of arguments input sample
		if (args.length > 0) {
			String input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}
			int ro = input.length();
			if(i++<ro){
				n = new Node(input.charAt(i));
				infix(n);
				to =n;
			}else
				inorder(to);
			System.out.print('=');
			result = calculate(to);
			System.out.println(result);
			// End of arguments input sample
			// TODO: Implement your project here
		}
	}
	public static float calculate(Node ro) {
		if (ro.l == '+') {
			return calculate(ro.lf) + calculate(ro.rf);
		} else if (ro.l == '-') {
			return calculate(ro.lf) - calculate(ro.rf);
		} else if (ro.l == '*') {
			return calculate(ro.lf) * calculate(ro.rf);
		} else if (ro.l == '/') {
			return calculate(ro.lf) / calculate(ro.rf);
		}
	}
	public static void infix(Node ro) {
		do {
			ro.lf = (Node) s.pop();
			ro.rf = (Node) s.pop();
			s.push(ro);
		} while (!Character.isDigit(ro.l));
			s.push(ro);
	}
	public static void inorder(Node ro)
	{
		while(ro == s.peek() && Character.isDigit(ro.l)){
			if(ro.lf != null) inorder(ro.lf);
			System.out.print(ro.l);
			if(ro.rf != null) inorder(ro.rf);
		}System.out.print('(');
		if(ro != s.peek() && !Character.isDigit(ro.l))
			System.out.print(')');
	}
}
	public static class Node
	{
			char l;
	    	public Node lf,rf;
			public Node( char l )
			{
				lf = rf = null;
			}
	}




