public class Node {
    char value_node;
    Node left;
    Node right;

    Node(){
        left = null;
        right = null;
    }

    public void SetLeft(Node left_node) {
        this.left = left_node;
    }

    public void  SetRight(Node right_node) {
        this.right = right_node;
    }

    public void SetValueNode(char Value) {
        this.value_node = Value;
    }
}
