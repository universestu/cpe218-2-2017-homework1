public class Node {
    private String value_node = "";
    private Node left,right;

    Node(){
        left = null;
        right = null;
    }

    public Node GetLeft() {
        return left;
    }

    public Node GetRight() {
        return right;
    }

    public void SetLeft(Node left_node) {
        this.left = left_node;
    }

    public void  SetRight(Node right_node) {
        this.right = right_node;
    }

    public void SetValueNode(String Value) {
        this.value_node = Value;
    }
}
