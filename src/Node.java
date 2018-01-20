
public class Node
{
    Node left,right;
    char ch;

    Node(Node l,char item,Node r) {
        ch = item;
        left = l;
        right = r;
    }
    public String toString() {
        return (right == null && left == null) ? Character.toString(ch) : "(" + left.toString()+ ch + right.toString() + ")";
    }

}
    