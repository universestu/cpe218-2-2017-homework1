
public class Homework1 {

    static int i = -1;
    static Tree tree = new Tree();
    static String[] k;
	

    public static void main(String[] args) {
        System.out.print("Input:");
       
        Scanner Input = new Scanner(System.in);
       
        String s = Input.nextLine();
       
        k = s.split("");
       
        maketree();
        
        inflix(tree.root);

        System.out.println("=" + calculate(tree.root));



    }

    public static void maketree() {
        i  =k.length-1;
        tree.root = new Node(k[i]);i--;        
            
                tree.root.right = new Node();
                tree.root.left = new Node();
                
           chack(tree.root.right);
           chack(tree.root.left);
            
    }
    
    public void Inorder(Node a) {
        if(a.left != null){
            Inorder(a.left);
        }
        System.out.print(a.key);
        if(a.right != null){
            Inorder(a.right);
        }
    }
   public static void chack (Node current) {
       current.key = k[i];
       if(Operator(k[i])){
           current.right = new Node();
           current.left = new Node();
           i--;
           chack(current.right);
           chack(current.left);
       }
       else{
           i--;
       }
  }

    public static boolean Operator(String k) {
           switch(k) {
                case "+" : return true;
                case "-" : return true;
                case "*" : return true;
                case "/" : return true;
                default : return false;
        }
    }

    public static int calculate(Node a) {
        if (Operator(a.key)) {
            switch(a.key) {
                case "+" : return calculate(a.left) + calculate(a.right);
                case "-" : return calculate(a.left) - calculate(a.right);
                case "*" : return calculate(a.left) * calculate(a.right);
                case "/" : return calculate(a.left) / calculate(a.right);
                default :; return 0;
        }
        
        }
            else{
            return Integer.parseInt(a.key);
    }
}
       public static void inflix(Node a) {
        if(Operator(a.key) && a != tree.root){
            System.out.print("(");
        }
       
        if(a.left != null){
            inflix(a.left);
        }
       
        System.out.print(a.key);
       
        if(a.right != null){
            inflix(a.right);
        }
       
        if(Operator(a.key) && a != tree.root){
            System.out.print(")");
        }
    }
}
