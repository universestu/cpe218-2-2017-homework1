
public class Homework1 {
    
    static Node root= null;
    static String[] k;
    public static String input ;
    public static int inputlength;

    public static void main(String[] args) {
      if (args.length > 0) {
           input = args[0];
           inputlength = input.length() - 1;       }

        Inorder(new Node(input.substring(inputlength)));

        inflix(root);

        System.out.println("=" + calculate(root));

    }

    public static void Inorder(Node a) {
        if (root == null){
            root = a;
            inputlength--;
        }
        a.key = k[inputlength];
        if (Operator(k[inputlength])) {
            root.right = new Node(input.substring(inputlength));
            inputlength--;
            Inorder(a.right);
            root.left = new Node(input.substring(inputlength));
            inputlength--;
            Inorder(a.left);
            
        } 
    }

    public static boolean Operator(String k) {
        switch (k) {
            case "+":
                return true;
            case "-":
                return true;
            case "*":
                return true;
            case "/":
                return true;
            default:
                return false;
        }
    }

    public static int calculate(Node a) {
        if (Operator(a.key)) {
            switch (a.key) {
                case "+":
                    return calculate(a.left) + calculate(a.right);
                case "-":
                    return calculate(a.left) - calculate(a.right);
                case "*":
                    return calculate(a.left) * calculate(a.right);
                case "/":
                    return calculate(a.left) / calculate(a.right);
                default:;
                    return 0;
            }

        } else {
            return Integer.parseInt(a.key);
        }
    }

    public static void inflix(Node a) {
        if (a == root) {
             inflix(a.left);
            System.out.print(a.key);
            inflix(a.right);
        } else if (Operator(a.key)) {
            System.out.print('(');
            inflix(a.left);
            System.out.print(a.key);
            inflix(a.right);
             System.out.print(')');
         } else {
             System.out.print(a.key);
         }
    }

    public static class Node{

        Node left;
        Node right;
        String key;

        public Node(String key) {
            this.key = key;
        }
    }
}
