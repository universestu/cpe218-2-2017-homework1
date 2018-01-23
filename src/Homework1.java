import javax.sound.midi.Soundbank;
import java.util.Stack;

public class Homework1 {

	public static void main(String[] args) {
		// Begin of arguments input sample
		String pfix = "0";

		try{
			pfix = args[0] ;
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("No args. !");
			return ;
		}

		if (args.length > 0) {
			if (pfix.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}
		}
//		else{
//			System.out.println("No args.");
//			return ;
//		}

		Stack<Node> a = new Stack<Node>() ;
		Node r0 = new Node("a"), r1 = new Node("a")  , r2 = new Node("a");

		for(int i=0 ; i< pfix.length() ; i++){
			if( isDigit(pfix.charAt(i)) ){//เป็นตัวเลข
				r0 = new Node(pfix.charAt(i)) ;
				a.push(r0) ;
			}else{ // เครื่องหมาย
				r0 = new Node(pfix.charAt(i)) ;
				r1 = a.pop() ;
				r2 = a.pop() ;
				r0.left = r2 ; r2.dad = r0 ;
				r0.right = r1 ; r1.dad = r0;
				a.push(r0) ;
			}
		}
		infix(r0) ;
		//inorder(r0) ;
	}


	static void infix(Node n){
		inorder(n) ;
		System.out.print("=" + calculate(n) );

	}

	static void inorder(Node n){
		if(!isDigit(n.item))
		{
			if(n.dad != null){
				System.out.print("("  );

				inorder(n.left);
				System.out.print(n.item  );
				inorder(n.right);

				System.out.print(")"  );
			}else{
				inorder(n.left);
				System.out.print(n.item  );
				inorder(n.right);
			}

		}else
		{
			System.out.print(n.item  );
		}

//        if (n != null) {
//
//        	if(n.left == null && n.dad.left == n)System.out.print("(");
//
//           inorder(n.left);
//           System.out.print(n.item);
//            inorder(n.right);
//        if(n.right == null && n.dad.right == n) System.out.print(")");
//        }
	}

	static int calculate(Node n){

		if(	isDigit(n.item)	) return toDigit(n.item) ;
		else{
			switch(n.item){
				case '+' : return  calculate(n.left) + calculate(n.right) ;
				case '-' : return  calculate(n.left) - calculate(n.right) ;
				case '*' : return  calculate(n.left) * calculate(n.right) ;
				case '/' : return  calculate(n.left) / calculate(n.right) ;
			}
		}
		return 0;
	}

	static boolean isDigit(char item)
	{
		return item >= '0' && item <= '9';
	}
	static int toDigit(char item)
	{
		return item - '0';
	}
}
