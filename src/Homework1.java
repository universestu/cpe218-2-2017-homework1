
public class Homework1 {
    
    public static int i;
    static Node root= null;
    static String[] k;
    public static String input ;
    public static int inputlength;

    public static void main(String[] args) {
      if (args.length > 0) {
           input = args[0];
           inputlength = input.length() - 1;       }

        maketree();

        inflix(root);

        System.out.println("=" + calculate(root));

    }

    public static void maketree() {
        i = k.length - 1;
        root = new Node(k[i]);
        i--;

        root.right = new Node(input.substring(i));
        root.left = new Node(input.substring(i));

        chack(root.right);
        chack(root.left);

    }

    public void Inorder(Node a) {
        if (a.left != null) {
            Inorder(a.left);
        }
        System.out.print(a.key);
        if (a.right != null) {
            Inorder(a.right);
        }
    }

    public static void chack(Node a) {
        a.key = k[i];
        if (Operator(k[i])) {
            root.right = new Node(input.substring(i));
            root.left = new Node(input.substring(i));
            i--;
            chack(a.right);
            chack(a.left);
        } else {
            i--;
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
