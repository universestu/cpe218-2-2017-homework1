public class Node {
    String value;
    Node left, right;

    public Node(String key){
        value = key;
        left = right = null;
    }

    public Node(Node left, String key, Node right){
        this.value = key;
        this.left = left;
        this.right = right;
    }

    public String getValue(){
        return this.value;
    }

    public int getIntValue(){
        String op = "+-*/";
        if( op.indexOf(value) == -1){
            return Integer.parseInt(this.value);
        }return 0;
    }


}
