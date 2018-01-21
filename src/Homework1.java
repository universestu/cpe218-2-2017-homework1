package homework1;

import java.util.Scanner;


public class Homework1 {

    
    static int l = -5;
    static Tree t = new Tree();
    
    public static String[] inputAry;
  
    public static void main(String[] args) {
	// Begin of arguments input sample
        System.out.print("Input: ");
        Scanner input = new Scanner(System.in);
        t.root = new Node();
       if (args.length > 0){
            String a = args[0];
            inputAry =  a.split("");
        }String a = "251-*32*+";
           inputAry = a.split("");
           
        treeCreate(t.root);
         infix(t.root);
        System.out.println("=" + calculate(t.root));
    }
    
    public static boolean oPera(String p){
        if(null == p)return false;
        else switch (p) {
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
 
    public static void treeCreate(Node n) {
        if(l == -5 ){
//           t.root = new Node(inputAry[l]);

            l = inputAry.length - 1;
        }
        n.key = inputAry[l];
        if(oPera(inputAry[l])){
            n.Right = new Node();
            n.Left = new Node();
            l--;
            treeCreate(n.Right);
            treeCreate(n.Left);
        }
        else{
            l--;
        }
    }   
    

        
        
      /*  t.root = new Node(inputAry[l]);
        n.key = inputAry[l];
        if(oPera(inputAry[l])){
            n.Right = new Node();
            n.Left = new Node();
            l--;
            treeCreate(n.Right);
            treeCreate(n.Left);
        }else l--;
    }
*/        
    public static void infix(Node n){
        if(oPera(n.key)){
            if(n != t.root){
                System.out.print("(");
            }
            infix(n.Left);
            System.out.print(n.key);    
            infix(n.Right);
            if(n != t.root){
                System.out.print(")");
            }
        }
        else{
            System.out.print(n.key);
        }  
    }
    
    public static void inorder(Node n) {
        if (oPera(n.key)){
            inorder(n.Left);
            System.out.print(n.key);
            inorder(n.Right);
        }else {
            System.out.print(n.key);
        }
        
    }
    
    public static int calculate(Node n){
        if(oPera(n.key)){
            if(null==n.key){ return Integer.parseInt(n.key);}else switch (n.key) {
                case "+":
                    return calculate(n.Left) + calculate(n.Right);
                case "-":
                    return calculate(n.Left) - calculate(n.Right);
                case "*":
                    return calculate(n.Left) * calculate(n.Right);
                case "/":
                    return calculate(n.Left) / calculate(n.Right); 
                default:
                    return Integer.parseInt(n.key);
            } 
        }else return Integer.parseInt(n.key);
    }
}
