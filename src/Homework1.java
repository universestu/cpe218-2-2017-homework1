import java.util.Stack;

public class Homework1 {
    static Stack stack = new Stack();
    public static void main(String[] args) {
        if (args.length > 0) {
            String input = args[0];
            for (int i = 0; i < input.length(); i++) {
                String token = input.substring(i, i + 1);
                infix(token);
            }
            Node value = (Node) stack.pop();
            String root = inorder(value);
            System.out.println(root.substring(1, root.length() - 1) + "=" + calculator(value));

        }
    }

    public static void infix(String x) {
        if (x.matches("[0-9]")) {
            stack.push(new Node(x, null, null));
        } else {
            Node right = (Node) stack.pop();
            Node left = (Node) stack.pop();
            stack.push(new Node(x, left, right));
        }
    }

    public static String inorder(Node x) {
        String value = "";
        if (x.left != null) {
            value += "(" + inorder(x.left);
        }
        value += x.root;
        if (x.right != null) {
            value += inorder(x.right) + ")";
        }
        return value;
    }

    public static int calculator(Node x) {
        if (x.root.matches("[0-9]")) {
            return Integer.parseInt(x.root);
        }
        int value = 0;
        int left = calculator(x.left);
        int right = calculator(x.right);
        String operand = x.root;
        switch (operand) {
            case "+":
                value = left + right;
                break;
            case "-":
                value = left - right;
                break;
            case "*":
                value = left * right;
                break;
            case "/":
                value = left / right;
                break;

        }
        return value;


    }
}




