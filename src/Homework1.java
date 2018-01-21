import java.util.Scanner;
import java.util.Stack;
import javax.imageio.metadata.IIOMetadataNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Homework1 {
	static Stack<Character> _stack = new Stack<Character>();
	static Node root;
	
	static public void inorder(Node n) {
		if (n != null){
			if(isOperate(n.getNodeName().charAt(0)) && n != root) System.out.print("(");
			NodeList list = n.getChildNodes();
			inorder(list.item(1)); //recursive left node
            System.out.print(n.getNodeName());   //print itself
            inorder(list.item(0));    //recursive right node
            if(isOperate(n.getNodeName().charAt(0)) && n != root) System.out.print(")");
		}
	}
	
	static public void infix(Node n) {
		//base case
		if(!isOperate(n.getNodeName().charAt(0))) {
			n.setNodeValue(n.getNodeName());
			return;
		}
		
		Node second_child = new IIOMetadataNode(_stack.pop().toString());
		infix(second_child);
		
		Node first_child = new IIOMetadataNode(_stack.pop().toString());
		infix(first_child);
		
		n.appendChild(second_child);
		n.appendChild(first_child);
		calculate(n);
	}
	
	static public void calculate(Node n) {
		NodeList list = n.getChildNodes();
		int first_value = Integer.parseInt(list.item(1).getNodeValue());
//		System.out.println("1st -> " + first_value);
		int second_value = Integer.parseInt(list.item(0).getNodeValue());
//		System.out.print("2nd -> " + second_value);
		int result = 0;
		switch(n.getNodeName()) {
			case "+" :{
				result = first_value + second_value;
				break;
			}
			case "-" :{
				result = first_value - second_value;
				break;
			}
			case "*" :{
				result = first_value * second_value;
				break;
			}
			case "/" :{
				result = first_value / second_value;
				break;
			}
		}
//		System.out.println(" | " + first_value + n.getNodeName() + second_value + "=" + result);
		n.setNodeValue(Integer.toString(result));
	}
	
	public static boolean isOperate(char _string) {
		//System.out.println("string is " + _string);
		return	(_string == '+' || _string == '-' || 
				_string == '*' || _string == '/');
	}
	
	public static void main(String[] args) {
		// Begin of arguments input sample
//		if (args.length > 0) {
//			String input = args[0];
//			if (input.equalsIgnoreCase("251-*32*+")) {
//				System.out.println("(2*(5-1))+(3*2)=14");
//			}
//		}
		// End of arguments input sample
		
		// TODO: Implement your project here
		
		String data = "251-*32*+";;
		
		//data = "251-*32*+";
		
//		Scanner scanInput = new Scanner(System.in);
//		data = scanInput.nextLine();
//
//		scanInput.close();            
//		System.out.println(data.length());
		
		if(args.length > 0) data = args[0];
		
		for(int i = 0; i < data.length(); i++) {
//			System.out.print(data.charAt(i));
			_stack.push(data.charAt(i));
		}
//		System.out.println();
		
		root = new IIOMetadataNode(_stack.pop().toString());
		infix(root);
		inorder(root);
        System.out.print("=" + root.getNodeValue());
	}
}