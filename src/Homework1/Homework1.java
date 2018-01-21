/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Homework1;
/**
 *
 * @author PDA
 */

//import java.util.Scanner;

public class Homework1 {

    /**
     * @param args the command line arguments
     */
    static int i = -1;
    static Tree tree = new Tree();
    static String[] ary;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        if (args.length > 0) {
            System.out.print("Output:");
        
            String s = args[0];

//            Scanner terminalInput = new Scanner(System.in);
//            String s = terminalInput.nextLine();
            ary = s.split("");

            if(ary.length < 3){
                System.out.println("Error");
                return ;
            }
            
            Createtree();
            inflix(tree.root);
            System.out.println("=" + calculate(tree.root));
	}
    }
    public static void Createtree() {
        i = ary.length - 1;
        tree.root = new Node(ary[i]);
        i--;
        
        tree.root.Right = new Node();
        tree.root.Left = new Node();
        
        Settree(tree.root.Right);
        Settree(tree.root.Left);
    }
    
    public static void Settree(Node current) {
        current.key = ary[i];
        if(TrueIsOperator(ary[i])){
            current.Right = new Node();
            current.Left = new Node();
            i--;
            Settree(current.Right);
            Settree(current.Left);
        }
        else{
            i--;
        }
    }
    
    public static boolean TrueIsOperator(String a){
        switch(a){
            case "+":return true;
            case "-":return true;
            case "*":return true;
            case "/":return true;
            default : return false;
        }
    }
    
    public static void inflix(Node n) {
        if(TrueIsOperator(n.key) && n != tree.root){
            System.out.print("(");
        }
        
        if(n.Left != null){
            inflix(n.Left);
        }
        
        System.out.print(n.key);
        
        if(n.Right != null){
            inflix(n.Right);
        }
        
        if(TrueIsOperator(n.key) && n != tree.root){
            System.out.print(")");
        }
    }
    
    public static void inorder(Node n) {
        if(n.Left != null){
            inorder(n.Left);
        }
        System.out.print(n.key);
        
        if(n.Right != null){
            inorder(n.Right);
        }
    }
    
    public static int calculate(Node n) {
        if(TrueIsOperator(n.key)){
            switch(n.key){
                case "+":return calculate(n.Left) + calculate(n.Right);
                case "-":return calculate(n.Left) - calculate(n.Right);
                case "*":return calculate(n.Left) * calculate(n.Right);
                case "/":return calculate(n.Left) / calculate(n.Right);
                default : System.out.println("Not Operator || Number");return 0;
            }
        }
        else{
            return Integer.parseInt(n.key);
        }
    }
}
