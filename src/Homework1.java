
public class Homework1 {

    public static String input ;
    public static int inputlength;

    public static void main(String[] args) {
        // Begin of arguments input sample

        if (args.length > 0) {
            input = args[0];
            inputlength = input.length() - 1;
        }
        makeTree(new Node(input.charAt(inputlength)));

        infix(root);
        System.out.print("=" + calculate(root));
    }
    // End of arguments input sample

    // TODO: Implement your project here
    static Node root;

    public static void infix(Node n) {
        if (n == root) {
            infix(n.left);
            System.out.print(n.key);
            infix(n.right);
        } else if (IsOp(n)) {
            System.out.print('(');
            infix(n.left);
            System.out.print(n.key);
            infix(n.right);
            System.out.print(')');
        } else {
            System.out.print(n.key);
        }
    }

    public static void inorder(Node n) {
        if (IsOp(n)) {
            inorder(n.left);
            System.out.print(n.key);
            inorder(n.right);
        } else {
            System.out.print(n.key);
        }
    }

    public static void makeTree(Node n) {
        if (root == null) {
            root = n;
            inputlength--;
        }
        if (IsOp(n)) {
            n.right = new Node(input.charAt(inputlength));
            inputlength--;
            makeTree(n.right);
            n.left = new Node(input.charAt(inputlength));
            inputlength--;
            makeTree(n.left);
        }

    }

    public static int calculate(Node n) {
        if (IsOp(n)) {
            switch (n.key) {
                case '+':
                    return calculate(n.left) + calculate(n.right);
                case '-':
                    return calculate(n.left) - calculate(n.right);
                case '/':
                    return calculate(n.left) / calculate(n.right);
                case '*':
                    return calculate(n.left) * calculate(n.right);
            }
        } else {
            return Character.getNumericValue(n.key);
        }
        return 0;
    }

    public static boolean IsOp(Node n) {
        return n.key == '+' || n.key == '-' || n.key == '*' || n.key == '/';
    }



    public static class Node {

        Node left;
        Node right;

        char key;

        public Node(char data) {
            this.key = data;
        }

    }

}
