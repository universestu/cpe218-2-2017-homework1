//package net.codejava.swing;
import java.util.NoSuchElementException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.JTree;



public class Homework1 {




	public static String infix(Node node) {

		StringBuilder infix = new StringBuilder();
		infix = inorder(node);

		infix.deleteCharAt(0);
		infix.deleteCharAt(infix.length()-1);
		for(int i =1;i<infix.length()-1;i++) {

			if(infix.charAt(i-1) == '(' && !is_operater(infix.charAt(i)) && infix.charAt(i+1) == ')') {
				infix.setCharAt(i-1, ' ');
				infix.setCharAt(i+1, ' ');
			}else if(infix.charAt(i)== ' ') {

				continue;
			}

		}

		for(int i=0;i<infix.length();i++) {

			if(infix.charAt(i) == ' ') {
				infix.deleteCharAt(i);

			}

		}


		return infix.toString();
	}

	public static StringBuilder inorder(Node node) {

		StringBuilder infix = new StringBuilder();

		subinorder(node,infix);

		return infix;

	}

	public static void subinorder(Node node,StringBuilder infix) {

		if (node != null) {
			infix.append("(");
			subinorder(node.left, infix);
			infix.append(node.value);
			subinorder(node.right, infix);
			infix.append(")");
		}

	}


	public static boolean is_operater(char x) {

		if(x== '+' || x=='-' || x=='*' || x=='/') {

			return true;

		}


		return false;

	}

	public static boolean ishasoperater(String text) {

		for(int i=0;i<text.length();i++) {

			if(is_operater(text.charAt(i))){
				return true;
			}

		}

		return false;
	}

	public static int calculate(Node node) {




		if(node.value == '+') {

			return calculate(node.left) + calculate(node.right);

		}else if(node.value == '-') {

			return calculate(node.left) - calculate(node.right);

		}else if(node.value == '*') {

			return calculate(node.left) * calculate(node.right);

		}else if(node.value == '/') {

			return calculate(node.left)  / calculate(node.right);

		}else return Integer.parseInt((String.valueOf(node.value)));


	}

	public static Node bulit_tree(char posfix_array []) {

		Stack<Node> data = new Stack();
		Node node,num1,num2;

		for(int i=0;i<posfix_array.length;i++) {

			if(!is_operater(posfix_array[i])) {

				node = new Node(posfix_array[i]);
				data.push(node);

			}else {

				node = new Node(posfix_array[i]);
				num2 = data.pop();
				num1 = data.pop();

				node.left = new Node();
				node.left = num1;
				node.right = new Node();
				node.right = num2;

				data.push(node);




			}

		}

		node = data.peek();
		return node;



	}


	public static void main(String[] args) {
		// Begin of arguments input sample

		/*String posfix = "0";

		try{
			posfix = args[0] ;
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("No args. !");
			return ;
		}*/

		String posfix = args[0];



		/*if (args.length > 0) {
			String input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				//System.out.println("(2*(5-1))+(3*2)=14");
			}
		}*/



		char [] postfix_array = posfix.toCharArray();

		Node root = bulit_tree(postfix_array);

		System.out.println(infix(root) + "=" + calculate(root));

	}
}
