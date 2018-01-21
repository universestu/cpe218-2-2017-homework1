
import java.util.Stack;

public class Homework1 {
	static Stack St = new Stack();
	public static void main(String[] args) {
		Node Rt = null;
		String input = "";
		// Begin of arguments input sample
		if (args.length > 0) {
			input = args[0];
		}

		for(int i=0; i< input.length();i++){
			String now = input.substring(i,i+1);
			Node n = new Node(now,null,null);
			Infix(n);
		}
		Rt = (Node) St.pop();
		String Output = Inorder(Rt);
		System.out.println(Output.substring(1,Output.length()-1) + " = " + Calculate(Rt));


	}

	public static void Infix(Node n){
		if(!CheckOp(n.root)){
			St.push(n);
		}
		else{
			n.R = (Node) St.pop();
			n.L = (Node) St.pop();
			St.push(n);
		}
	}

	public static String Inorder(Node n){
		String postfix = "";
		if (n.L != null){
			postfix += "(" + Inorder(n.L);
		}
		postfix += n.root;
		if(n.R != null){
			postfix += Inorder(n.R) + ")";
		}
		return postfix;
	}

	public static int Calculate(Node n){
		if (!CheckOp(n.root)){
			return Integer.parseInt(n.root);
		}
		int sum1 = Calculate(n.L);
		int sum2 = Calculate(n.R);

		return Checkcase(n.root,sum1,sum2);
	}

	public static int Checkcase(String x,int y,int z){
		switch (x){
			case "+":
				return y+z;
			case "-":
				return y-z;
			case "*":
				return y*z;
			case "/":
				return y/z;
		}
		return 0;
	}
	public static boolean CheckOp (String op){
		switch (op){
			case "+":
				return true;
			case "-":
				return true;
			case "*":
				return true;
			case "/":
				return true;
			default:
				return false;

		}
	}
}
