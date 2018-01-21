public class Node {
    char op;
    Node left,right,txt;
    Node(Node left,char op,Node right){
        this.left = left;
        this.right = right;
        this.op = op;
    }
    public Node(Node txt) {
        this.txt = txt;
    }

}
