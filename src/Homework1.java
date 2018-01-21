
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Tin
 */

public class Homework1 {
    
    public static void main(String[] args) {
        // Begin of arguments input sample
        Node root = new Node('E');
             root.Value = args[0];
   //     root.Value = "251-*32*+";
        root = CreateTree(root);
        //        System.out.println("Ans = "+Calculate(root));
        String Ans = new String();
        String[] Answ = Infix(root).split("");
        for(int i=1; i<Infix(root).length()-1;i++)
        {
            Ans += Answ[i];
        }
        System.out.println(Ans + "=" +Calculate(root));
        //     System.out.println(InOrder(root));
        // TODO: Implement your project here
    }
    
    public static Node CreateTree(Node n)
    {
        Stack<Character> Stack_Question=new Stack<Character>();
        String[] Arr_Of_Question = n.Value.split("");
        
        for(String Arr_Q : Arr_Of_Question )
        {
            Stack_Question.add(Arr_Q.charAt(0));
        }
        if(Stack_Question.size()<=1){
            System.out.println("Wrong Input!!!");
            return null;
        }else
            n = toTree(n,Stack_Question);
        
        return n;
    }
    
    public static String Infix(Node n){
        
        if(isOperator(n.Op))
        {
            return ("(" +Infix(n.Node_Right)+ n.Op+ Infix(n.Node_Left) +")");
        }else
        {
            return (""+ n.Op);
        }
        
    }
    
    public static String InOrder(Node n){
        if( n.Node_Left != null && n.Node_Right != null){
            return (n.Op +" " + InOrder(n.Node_Right) + " " + InOrder(n.Node_Left)) ;
        }else return (n.Op+"");
        
    }
    
    public static int Calculate(Node n){
        //       System.out.println(n.Op);
        if(isOperator(n.Op)){
            if(n.Op=='+')
            {
                return Calculate(n.Node_Left)+Calculate(n.Node_Right);
            }else if(n.Op=='-')
            {
                return Calculate(n.Node_Right)-Calculate(n.Node_Left);
            }else if(n.Op=='*')
            {
                return Calculate(n.Node_Left)*Calculate(n.Node_Right);
            }else if(n.Op=='/')
            {
                return Calculate(n.Node_Right)/Calculate(n.Node_Left);
            }
        }else if(isNumber(n.Op)){
            return n.Op-'0';
        }else {
            System.out.println("Calculate Error!!");
        }
        
        return n.Ans;
    }
    
    public static class Node{
        String Value;
        char Op;
        int Ans;
        Node Node_Left, Node_Right;
        public Node(Character Op){
            this.Op = Op;
        }
    }
    
    public static Node toTree(Node root, Stack<Character> Ques)
    {
        root = new Node(Ques.pop());
        if(isOperator(Ques.peek())){
            //       System.out.println(isOperator(Ques.peek()) +" OP Left "+ Ques.peek());
            if(Ques.size()<=1){
                System.out.println("Error Ran Out of Number L");
                return root;
            }else{
                root.Node_Left = toTree(root.Node_Left, Ques);
            }
        }else if(isNumber(Ques.peek()))
        {
            //        System.out.println(root.Op + " Number Left");
            root.Node_Left = new Node(Ques.pop());
        }else
        {
            System.out.println("Error Wrong Input L!!");
            return root;
        }
        if(isOperator(Ques.peek())){
            //         System.out.println(isOperator(Ques.peek()) +" OP Right "+ Ques.peek());
            if(Ques.capacity()<=1){
                System.out.println("Error Ran Out of Number R");
                return root;
            }else{
                root.Node_Right = toTree(root.Node_Right, Ques);
            }
        }else if(isNumber(Ques.peek()))
        {
            //         System.out.println(root.Op + " Number Right");
            root.Node_Right = new Node(Ques.pop());
        }else
        {
            System.out.println("Error Wrong Input!! R");
            return root;
        }
        
        return root;
    }
    
    
    public static boolean isNumber(char s) {
        
        if ("1234567890".indexOf(s) != -1){
            return true;
        }
        return false;
    }
    
    public static boolean isOperator(char s){
        if("+-*/".indexOf(s)!=-1)
        {
            return true;
        }
        return false;
    }
}


