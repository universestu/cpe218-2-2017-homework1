import java.util.Stack;


public class Homework1 {
	
	public static  Node tree ;
	
	public static Stack<Character> sk =new Stack<Character>();
	
	public static void main(String[] args) {
		
		String input ="251-*32*+";

		for(int i=0;i<input.length();i++){
			sk.add(input.charAt(i));
		}
		tree = new Node(sk.pop());
		
		infix(tree);
		
		inorder(tree);
		
		System.out.print("="+Calculate(tree));
		

	}
	public static void infix(Node n){
		
		if(n.key == '+' || n.key == '-' || n.key == '*' || n.key == '/'){
			
			n.right = new Node(sk.pop());
			
			infix(n.right);
			
			n.left = new Node(sk.pop());
			
			infix(n.left);
			
		}
		
	}
	
	public static void inorder(Node n) {
		
		if(n.key == '+' || n.key == '-' || n.key == '*' || n.key == '/')
		{
			if(n!=tree)System.out.print("(");
			
			inorder(n.left);
			
			System.out.print(n.key);
			
			inorder(n.right);
			
			if(n!=tree)System.out.print(")");
		}else
			
		{
			System.out.print(n.key);
			
		}
	}
	public static int Calculate(Node n){
		
		if(n.key == '+')
			
		{
			return Calculate(n.left)+Calculate(n.right);
			
		}
		
		else  if(n.key == '-')
			
		{
			return Calculate(n.left)-Calculate(n.right);
			
		}
		else  if(n.key == '*')
			
		{
			return Calculate(n.left)*Calculate(n.right);
			
		}
		else  if(n.key == '/')
			
		{
			
			return  Calculate(n.left)/Calculate(n.right);
			
		}
		
		else return Integer.parseInt(n.key.toString());
		
	}
	



	
	
}
