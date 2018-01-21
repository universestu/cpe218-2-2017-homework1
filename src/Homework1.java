
import java.util.Stack;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import package.Node;

public class Homework1 {

	static String infix="" ;
 	public static void main(String[] args) throws ScriptException {
		Node root = null;
		for (int i = 0; i < args.length; i++) {
			Stack<Node> mem = new Stack();
			for (int j = 0; j < args[i].length(); j++) {
				mem.push(new Node(args[i].toCharArray()[j]));

			}
		}
		root = CreateTree(args[i].toCharArray());
	}

	public static boolean IsOperator (char c){
		if(c == '+' || c == '-' || c == '*' || c == '/'){
			return true;
		}
		return false;
	}

	public static Node CreateTree(char []postfix){

	}
}

	// End of arguments input sample
		// TODO: Implement your project here






