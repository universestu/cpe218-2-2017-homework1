import java.util.Stack;
import java.util.Scanner;

public class Homework1 {

public static Node Tree;
public static Stack<Character> Temp = new Stack<Character>();  


public static class Node
{
        Node left;
        Node right;
        char key;
    
        public Node(char n) 
        {
            key = n;
        }
}
  
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);

        if(args.length >0){
        Tree = new Node(Temp.pop());
        infix(Tree);
        inorder(Tree);
        System.out.print(" = " + calculate(Tree));
        }
    }

    public static void inorder(Node n){
        if (n.key == '+' || n.key == '-' || n.key == '*' || n.key == '/'){
                if(n!=Tree){
                        System.out.print("(");
                    }
                    inorder(n.left);
                    System.out.print(n.key);
                    inorder(n.right);
                if(n!=Tree){
                    System.out.print(")");
                    }
                }else {
                    if(n!=Tree){
                            System.out.print(n.key);
                     }
                    }
    }

    public static void infix(Node a) {

                    if (a.key == '+' || a.key == '-' || a.key == '*' || a.key == '/') {
                            a.right = new Node(Temp.pop());
                            infix(a.right);
                            a.left = new Node(Temp.pop());
                            infix(a.left);
                    }
            }
    public static String input;
    public static int inputL;
    public static Node root;
    public static void makeTree(Node n) {
        if (root == null) {
            root = n;
            inputL--;
        }
        if (IsOperator(n)) {
            n.right = new Node(input.charAt(inputL));
            inputL--;
            makeTree(n.right);
            n.left = new Node(input.charAt(inputL));
            inputL--;
            makeTree(n.left);
        }

    }
    
    public static boolean IsOperator(Node n) {
       return n.key == '+' || n.key == '-' || n.key == '*' || n.key == '/';
    }
    
       public static int calculate(Node n) {
       if (IsOperator(n)) {
            switch (n.key) {
                case '+':
                    return calculate(n.left) + calculate(n.right);
                case '-':
                    return calculate(n.left) - calculate(n.right);
                case '/':
                    return calculate(n.left) / calculate(n.right);
                case '*':
                    return calculate(n.left) * calculate(n.right);
            }
        } else {
            return Character.getNumericValue(n.key);
        }
        return 0;
    }    
}
