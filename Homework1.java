
import java.util.Stack;


 class Node {
 
    char value;
    int number;
    Node left,right,pre;

    Node(char item) {
        value = item;
        number=Character.getNumericValue(item);
        pre = left = right = null;
        
    }
    
    Node(int num){
    
    number=num;
    }
}

public class Homework1 {
    
    static int sum=0;
    int usecal=0;
    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }
 
    // Utility function to do inorder traversal
    void inorder(Node t){//?????????????????? inorder(right) ??????? infix
        if (isOperator(t.value)) {            
            inorder(t.left);           
            infix(t);
            
        }
    }
 
    void infix(Node t){    
            
        if(t.pre==null&&!isOperator(t.left.value)&&!isOperator(t.right.value)){//root
        System.out.print(t.left.value); 
                System.out.print(t.value);                
                System.out.print(t.right.value);
        
        }        
        else if(!isOperator(t.left.value)&&!isOperator(t.right.value)){ //???????????????????????
                System.out.print("("+t.left.value); 
                System.out.print(t.value);                
                System.out.print(t.right.value+")");                 
            }        
         else if(t.pre!=null&&!isOperator(t.left.value)&&isOperator(t.right.value)){ //??????????????????????????????Operator
             System.out.print("("+t.left.value);                                       //??????????????? root
             System.out.print(t.value);   
             inorder(t.right);
             System.out.print(")");                    
         } 
         else if(isOperator(t.right.value)){ //???????????????????????????????? Operator
             if(!isOperator(t.left.value)) System.out.print(t.left.value);
             System.out.print(t.value);
             inorder(t.right);         
         }
        
          else if(isOperator(t.left.value)&&!isOperator(t.left.value)){
               
             System.out.print("("+t.value);   
             System.out.print(t.right.value+")");
         
          }
           else if(!isOperator(t.left.value)){ //????????????????????
                System.out.print(t.left.value);
                System.out.print(t.value);
            }
       
        
        
        
         else if(isOperator(t.left.value)){//????????????????? Operator
             System.out.print(t.value);   
             System.out.print(t.right.value);  }
            
    
    
    }
 
    // Returns root of constructed tree for given
    // postfix expression
    Node constructTree(char postfix[]) { //???????????? method calculator ?????
        Stack<Node> st = new Stack();
        Stack<Node> stcal =new Stack();
        Node t, t1, t2;
        Node a,a1,a2;
        
        // Traverse through every character of
        // input expression
        for (int i = 0; i < postfix.length; i++) {
 
            // If operand, simply push into stack
            if (!isOperator(postfix[i])) {
                t = new Node(postfix[i]);
                st.push(t);
                stcal.push(t); // ?????????????????????
            } else // operator
            {               
                t = new Node(postfix[i]);
 
                // Pop two top nodes
                // Store top
                t1 = st.pop();      // Remove top
                t2 = st.pop();
 
                //  make them children
                
                
                
                t.right = t1;
                t.left = t2;     
                
                t.right.pre=t;
                t.left.pre=t;
              
                // System.out.println(t1 + "" + t2);
                // Add this subexpression to stack
                st.push(t);
                
                //cal
               a2=stcal.pop();
               a1=stcal.pop();
               
            if(t.value=='+') sum=a1.number+a2.number;
            else if(t.value=='-') sum=a1.number-a2.number;
            else if(t.value=='*') sum=a1.number*a2.number;
            else if(t.value=='/') sum=a1.number/a2.number;
            
            a=new Node(sum);
            stcal.push(a);
            }
        }
        
        
 
        //  only element will be root of expression
        // tree
        t = st.peek();
        st.pop();
 
        return t;
    }
    
  
    public static void main(String[] args) {
		// Begin of arguments input sample
	Homework1 et = new Homework1();
        char[] charArray = args[0].toCharArray();
        Node root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);
         System.out.print("="+sum);
    }

}
