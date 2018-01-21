import java.util.Stack;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
public class Homework1 {
	static String infix="" ;
	public static void main(String[] args) throws ScriptException {
	
		Node root = null;
		
		
		for(int i=0;i<args.length;i++) {
			Stack<Node> mem = new Stack();
			
			
		for(int j=0;j<args[i].length();j++) {
       mem.push(new Node(args[i].toCharArray()[j]));
  
		}
		 

		root = constructTree(args[i].toCharArray());
		 root.isRoot=true;
	   infix(root);
	   System.out.printf("=");
	 calculate(root);
	 infix="" ;
		}
		
		}
	

	
	public static void inorder(Node n) {
		if(n !=  null) {
			if(!(n.data=='1' || n.data=='2' || n.data=='3' || n.data=='4' || n.data=='5' ||
					n.data=='6' ||  n.data=='7' ||  n.data=='8' ||  n.data=='9' ||  n.data=='0') ) {
				if(n.isRoot==false)
		//	System.out.printf("(");
				infix=infix+"(";	
			}
			inorder(n.left);
			//Visit the node by Printing the node data  
		 
			
			
		//	System.out.printf("%c",n.data);
			infix=infix+n.data;
			inorder(n.right);
			
			if(!(n.data=='1' || n.data=='2' || n.data=='3' || n.data=='4' || n.data=='5' ||
					n.data=='6' ||  n.data=='7' ||  n.data=='8' ||  n.data=='9' ||  n.data=='0')  ) {
				if(n.isRoot==false)
				//System.out.printf(")");
				infix=infix+")";}
				
	}
	}
	
	public static void infix(Node n) {
		if(n !=  null) {
			if(!(n.data=='1' || n.data=='2' || n.data=='3' || n.data=='4' || n.data=='5' ||
					n.data=='6' ||  n.data=='7' ||  n.data=='8' ||  n.data=='9' ||  n.data=='0') ) {
				if(n.isRoot==false)
			System.out.printf("(");
				//infix=infix+"(";	
			}
			infix(n.left);
			//Visit the node by Printing the node data  
		 
			
			
			System.out.printf("%c",n.data);
			//infix=infix+n.data;
			infix(n.right);
			
			if(!(n.data=='1' || n.data=='2' || n.data=='3' || n.data=='4' || n.data=='5' ||
					n.data=='6' ||  n.data=='7' ||  n.data=='8' ||  n.data=='9' ||  n.data=='0')  ) {
				if(n.isRoot==false)
				System.out.printf(")");
				//infix=infix+")";
				}
				
	}
	}
	

	
	public static void calculate(Node n) throws ScriptException {
		//infix(n);
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		inorder(n);
		System.out.println(engine.eval(infix));
		
	}
	
	static boolean isOperator(char c) {
		if (c == '+' || c == '-'|| c == '*' || c == '/') {
			return true;
		}
		return false;
	}
	
	static Node constructTree(char postfix[]) {
		Stack<Node> stackMem = new Stack();
		Node mem, mem1, mem2;
     for (int i = 0; i < postfix.length; i++) {
         if (!isOperator(postfix[i])) {
				mem = new Node(postfix[i]);
				stackMem.push(mem);
			} else 
			{
				mem = new Node(postfix[i]);
                mem1 = stackMem.pop();	 
				mem2 = stackMem.pop();
                mem.right = mem1;
				mem.left = mem2;
				stackMem.push(mem);
			}
		}
       mem = stackMem.peek();
		stackMem.pop();

		return mem;
	}
}
