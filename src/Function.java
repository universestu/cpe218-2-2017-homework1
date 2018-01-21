import java.util.Stack;

public class Function {

    public Stack stack = new Stack();

    public void infix(Node N) {
        if (N.node.matches("[0-9]")) {
            stack.push(N);
        } else {
            N.rightNode = (Node) stack.pop();
            N.leftNode = (Node) stack.pop();
            stack.push(N);
        }
    }

    public String inorder(Node N) {
        String temp = "";
        if (N.leftNode != null) {
            temp += "(" + inorder(N.leftNode);
        }
        temp += N.node;
        if (N.rightNode != null) {
            temp += inorder(N.rightNode) + ")";
        }
        return temp;
    }

    public int calculate(Node N) {

        if (N.node.matches("[0-9]")) {
            return Integer.parseInt(N.node);
        }

        int value = 0;
        int left = calculate(N.leftNode);
        int right = calculate(N.rightNode);

        if (N.node.equals("+")) {
            value = left + right;
        } else if (N.node.equals("-")) {
            value = left - right;
        } else if (N.node.equals("*")) {
            value = left * right;
        } else if (N.node.equals("/")) {
            value = left / right;
        }

        return value;
    }
}
