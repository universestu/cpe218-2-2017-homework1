
import sun.java2d.pipe.PixelDrawPipe;

import java.security.cert.Extension;
import java.util.Stack;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Homework1 {
	public static  Node tree ;
	public static Stack<Character> Box =new Stack<Character>();
	public static void main(String[] args) {
		// Begin of arguments input sample
		String input ="251-*32*+";
//		if (args.length > 0) {
//			String input = args[0];
//			if (input.equalsIgnoreCase("251-*32*+")) {
//				System.out.println("(2*(5-1))+(3*2)=14");
//			}
//		}
		for(int i=0;i<input.length();i++){
			Box.add(input.charAt(i));
		}
		tree = new Node(Box.pop());
		Infix(tree);
		iNorder(tree);
		System.out.print("="+Calculate(tree));

	}
	public static void Infix(Node Pisit){
		if(Pisit.Mind == '+' || Pisit.Mind == '-' || Pisit.Mind == '*' || Pisit.Mind == '/'){
			Pisit.right = new Node(Box.pop());
			Infix(Pisit.right);
			Pisit.left = new Node(Box.pop());
			Infix(Pisit.left);
		}
	}
	public static int Calculate(Node Dota){
		if(Dota.Mind == '+')
		{
			return Calculate(Dota.left)+Calculate(Dota.right);
		}
		else  if(Dota.Mind == '-')
		{
			return Calculate(Dota.left)-Calculate(Dota.right);
		}
		else  if(Dota.Mind == '*')
		{
			return Calculate(Dota.left)*Calculate(Dota.right);
		}
		else  if(Dota.Mind == '/')
		{
			return  Calculate(Dota.left)/Calculate(Dota.right);
		}
		else return Integer.parseInt(Dota.Mind.toString());
	}

	public static void iNorder(Node Hong) {
		if(Hong.Mind == '+' || Hong.Mind == '-' || Hong.Mind == '*' || Hong.Mind == '/'){
			if(Hong!=tree)System.out.print("(");
			iNorder(Hong.left);
			System.out.print(Hong.Mind);
			iNorder(Hong.right);
			if(Hong!=tree)System.out.print(")");
		}else
		{
			System.out.print(Hong.Mind);
		}
	}


}
