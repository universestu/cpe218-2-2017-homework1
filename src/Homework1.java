
import java.util.Stack;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import package.Node;
import java.io.*;

public class Homework1 {

	static String infix="" ;
 	public static void main(String[] args) throws ScriptException {
		char a ;
		for (int i = 0; i < args.length; i++) {
			a[i]=args[i].toCharArray();
		}
		CreateTree(a);
	}
	public static boolean IsOperator (char c){
		if(c == '+' || c == '-' || c == '*' || c == '/'){
			return true;
		}
		return false;
	}

	public static Node CreateTree(char []postfix){

		Stack<Node> mem = new Stack();
		Stack<Node> parent = new Stack();
		Node mem1,pointer;

		Node root = null;

		for(int i=0;i<postfix.length;i++){
			mem.push(new Node(postfix[i]));
		}

		while(mem != null){
			mem1 = mem.pop();
			if(IsOperator(mem1.data)) {
				if (root == null) {
					root = mem1;
					pointer = root;
				} else {
					pointer.left = mem1;
					pointer = pointer.left;

				}
				parent.push(mem1);
			}else{
				if(pointer.left == null){
					pointer.left = mem1;
				}else{
					pointer.right=mem1;
					pointer=parent.pop();
					}
				}
			}
			return root;
		}

		public static void infix(Node n){

		}

		public static void inoder(Node n){

		}

		public static void calculate(Node n){

		}
	}

	// End of arguments input sample
		// TODO: Implement your project here






