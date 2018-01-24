
import java.util.Stack;

public class Homework1 {

    public static void main(String[] args) {
        // Begin of arguments input sample
        if (args.length > 0) {
            String input = args[0];
            Stack stack = new Stack();
            for (int i = 0; i < input.length(); i++) {
                char a = input.charAt(i);
                if (Character.isDigit(a)) {
                    // push
                    Node newNode = new Node(a);
                    stack.push(newNode);
                } else {
                    Node firstPopNode, secondPopNode;
                    firstPopNode = (Node) stack.pop();
                    secondPopNode = (Node) stack.pop();

                    Node newNode = new Node(a);
                    newNode.left = secondPopNode;
                    newNode.right = firstPopNode;
                    stack.push(newNode);
                }
            }

            Tree t = new Tree((Node) stack.pop());
            String y = inorder(t.root).substring(1,inorder(t.root).length()-1) + "=" + calculate(t.root);;
            System.out.println(y);


        }
    }

    public static int calculate(Node n) {
        if (Character.isDigit(n.key)) {
            return Integer.parseInt(n.key + "");
        }
        else {
            switch (n.key) {
                case '+':
                    return calculate(n.left) + calculate(n.right);
                case '-':
                    return calculate(n.left) - calculate(n.right);
                case '*':
                    return calculate(n.left) * calculate(n.right);
                default:
                    return calculate(n.left) / calculate(n.right);
            }
        }
    }

    public static void infix(Node n) {

    }

    public static String inorder(Node n) {
        if(Character.isDigit(n.key)) {
            return n.key + "";
        }
        else {
            return "(" + inorder(n.left) + n.key + inorder(n.right) + ")";
        }
    }

    public static class Tree {
             Node root;

        public Tree(Node root) {
            this.root = root;
        }
    }

    public static class Node {
        char key;
        String x;
        Node left;
        Node right;

        public Node(String x) {
            this.x = x;
        }

        public Node(char key) {
            this.key = key;
        }

    }
}



