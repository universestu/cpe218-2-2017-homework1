import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework1 {
	static Stack st = new Stack();
	public static void main(String[] args) {
		// Begin of arguments input sample
		String input = args[0];
		String ans = "";
		if (args.length > 0) {
	
			String line = "This order was placed for QT3000! OK?";
			String pattern = "[0-9]";
			Pattern r = Pattern.compile(pattern);
	  
			Node tempNode = new Node(null,null,null);
			
            for (int i = 0; i < input.length(); i++) {
				Matcher m = r.matcher(String.valueOf(input.charAt(i)));
                if (m.find()) {
                    st.push(new Node(String.valueOf(input.charAt(i)),null,null));
                } else {
					tempNode = new Node(String.valueOf(input.charAt(i)),null,null);
                    tempNode.Right = (Node) st.pop();
                    tempNode.Left = (Node) st.pop();
					st.push(tempNode);
				}
				
			}
			
			ans = Infix(tempNode) + "=" + Calculate(tempNode);
			System.out.println(ans);
	
		}
	
	}

	

	public static String Infix(Node n) {
        String s = Inorder(n);
		if (s.length() > 1){
            return s.substring(1, s.length() - 1);}
        else {
			return s;
		}
	}

	public static String Inorder(Node n) {
		String postfix = "";
			if (n.Left == null && n.Right == null){
				return n.root; 
			}else {
             if (n.Left != null) {
                postfix += "(" + Inorder(n.Left);
			}
			postfix += n.root;
             if (n.Right != null) {
                postfix += Inorder(n.Right) + ")";
            }
			}
        return postfix;
	}


	public static int Calculate(Node n) {
        if (n.Left == null && n.Right == null) {
            return Integer.parseInt(n.root);
        } else {
			int leftNum = Calculate(n.Left);
			int RightNum = Calculate(n.Right);
            switch (n.root) {
                case "+":
                    return  leftNum + RightNum;
                case "-":
                    return leftNum - RightNum;
                case "*":
                    return leftNum * RightNum;
				case "/":
                    return leftNum / RightNum;
            }
        }
		return 0;
    }

	
	public static class Node{
		private Node Left;
		private Node Right;
		private String root;

		public Node(){
			root = null;
			Left = null;
			Right = null;
		}

		public Node(String n, Node l, Node r) {
			root = n;
			Left = l;
			Right = r;
		}
	
	}
	
}

