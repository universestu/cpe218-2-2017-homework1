public class Node {
    public Node left;
    public Node Right;
    Character Data;
    public Node(Character data)
    {
        Data=data;
    }

    public String toString() {
        return Data.toString();
    }
}
