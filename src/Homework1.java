import java.util.Stack;

public class Homework1 {

    public static void main(String[] args) {
        // Begin of arguments input sample
        if (args.length > 0) {
            String input = args[0];
            if (input.equalsIgnoreCase("251-*32*+")) {
                System.out.println("(2*(5-1))+(3*2)=14");
            }

            // End of arguments input sample

            // TODO: Implement your project here

            Stack st = new Stack();
            for (int i = 0; i < input.length(); i++) {
                char car = input.charAt(i);
                if (car >= '0' && car <= '9') {
                    st.push(new Node(car + ""));
                } else {
                    String first = "", second = "";
                    int firstNo, secondNo, cal;

                    Node parentNode = new Node(car + "");
                    parentNode.rightChild = (Node) st.pop();
                    parentNode.leftChild = (Node) st.pop();
                    st.push(parentNode);
                }
            }
            Tree tree = new Tree((Node) st.pop());
            System.out.println(infix(tree.root));
            System.out.println(calculate(tree.root));

        }
    }

    public static String infix(Node n) {
        // transform postfix to infix
        String s = inorder(n);
        return s.substring(1, s.length() - 1);
    }


    public static String inorder(Node n) {
        // traversal leftTree > root > rightTree
        String s = "";
        if (n.leftChild == null && n.rightChild == null) {
            return n.data;
        }
        if (n.leftChild != null) {
            s += "(" + inorder(n.leftChild);
        }
        s += n.data;
        if (n.rightChild != null) {
            s += inorder(n.rightChild) + ")";
        }
        return s;
    }

    public static int calculate(Node n) {
        // calculate postfix using stack
        if (n.leftChild == null && n.rightChild == null) {
            return Integer.parseInt(n.data);
        } else {
            switch (n.data) {
                case "+":
                    return calculate(n.leftChild) + calculate(n.rightChild);
                case "-":
                    return calculate(n.leftChild) - calculate(n.rightChild);
                case "*":
                    return calculate(n.leftChild) * calculate(n.rightChild);
                default:
                    return calculate(n.leftChild) / calculate(n.rightChild);
            }
        }
    }

    public static class Node {

        public Node leftChild, rightChild;
        public String data;

        public Node() {
            this.leftChild = null;
            this.rightChild = null;
            this.data = null;
        }

        public Node(String data) {
            this.data = data;
        }

        public Node(Node leftChild, Node rightChild, String data) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.data = data;
        }

    }

    public static class Tree {

        public Node root;

        public Tree() {
            this.root = null;
        }

        public Tree(Node root) {
            this.root = root;
        }
    }


}
