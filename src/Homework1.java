import java.util.Stack;

public class Homework1 {
     static Stack s = new Stack();

	public static void main (String[] args)  {
        Node root = null;
		if (args.length > 0) {
            String input = args[0];

            for (int i = 0; i < input.length(); i++) {
                String value = input.substring(i,i+1);
                Node n = new Node(value,null,null);
                infix(n);

            }
            root = (Node)s.pop();
            String out = inorder(root);
            System.out.println(out.substring(1,out.length()-1) + "=" + calculate(root) );
		}

    }


	public static void infix(Node n){
            if (n.node.matches("[0-9]")) {
                s.add(n);

            } else {
                n.right = (Node) s.pop();
                n.left = (Node) s.pop();
                s.add(n);
            }
	}

	public static String inorder(Node n){
        String temp="";
        if(n.left != null){
            temp+= "(" + inorder(n.left);
        }
        temp+=n.node;
        if(n.right != null){
            temp+=inorder(n.right) + ")";
        }
        return temp ;
    }

	public static int calculate(Node n){

        if (n.node.matches("[0-9]")){
            return Integer.parseInt(n.node);
        }
        int value = 0;
        int left = calculate(n.left);
        int right = calculate(n.right);

        if(n.node.equals("+")){
            value = left+right;
        }else if (n.node.equals("-")){
            value = left-right;
        }else if (n.node.equals("*")){
            value = left*right;
        }else if (n.node.equals("/")){
            value = left/right;
        }
        return value;
	}
}
