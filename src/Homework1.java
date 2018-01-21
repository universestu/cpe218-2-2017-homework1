import java.util.Stack;
import static java.lang.Character.getNumericValue;
public class Homework1 {

	public static void main(String[] args) {
		// Begin of arguments input sample
		
		String w = "";
		if (args.length > 0) {
			w = args[0];
			
		}
		// End of arguments input sample
		
		// TODO: Implement your project here
		System.out.print(inorder(infix(w)));
	      System.out.println(" = "+calculate(infix(w)));
	}
	
	
	public static Node infix(String input)
    {
        Stack<Node> keepnode = new Stack<>();
        char[] b = input.toCharArray();
        
        
        for(int i =0;i<b.length;i++)
       {
            Node z = new Node();
            Node z1 = new Node();
            Node z2 = new Node();
           if(b[i]!='+'&&b[i]!='-'&&b[i]!='*'&&b[i]!='/')
           {
               z.data = b[i];
               keepnode.push(z);
           }
           else 
           {
               z.data = b[i];
               z1 = keepnode.pop();
               z2 = keepnode.pop();
               z.right = z1;
               z.left = z2;
               z1.parent = z;
               z2.parent = z;
               keepnode.push(z);
           }
       }
        return keepnode.pop();
    }
    
    
    
    
    public static String inorder(Node input)
   {
       
           if((input.left.data=='+'||input.left.data=='-'||input.left.data=='*'||input.left.data=='/')&&(input.right.data=='+'||input.right.data=='-'||input.right.data=='*'||input.right.data=='/'))
       {
           String x = inorder(input.left) + input.data + inorder(input.right);
         return x;
            
            
           
       }
           else if(input.left.data=='+'||input.left.data=='-'||input.left.data=='*'||input.left.data=='/')
           {
               String x = "("+inorder(input.left) + input.data + ""+input.right.data+")";
               return x;
           }
           else if(input.right.data=='+'||input.right.data=='-'||input.right.data=='*'||input.right.data=='/')
           {
               String x = "("+input.left.data+"" + input.data + inorder(input.right)+")";
               return x;
           }
       
       
           else
       {
         return "("+input.left.data + input.data + input.right.data+")" ;
       }
   }




public static int calculate(Node input)
    {
       
        if((input.left.data=='+'||input.left.data=='-'||input.left.data=='*'||input.left.data=='/')&&(input.right.data=='+'||input.right.data=='-'||input.right.data=='*'||input.right.data=='/'))
       {
           int x = sum(calculate(input.left),calculate(input.right),input.data);
         return x;
            
            
           
       }
           else if(input.left.data=='+'||input.left.data=='-'||input.left.data=='*'||input.left.data=='/')
           {
               
               int x = sum(calculate(input.left), getNumericValue(input.right.data),input.data);
               return x;
           }
           else if(input.right.data=='+'||input.right.data=='-'||input.right.data=='*'||input.right.data=='/')
           {
               
               int x = sum( getNumericValue(input.left.data),calculate(input.right),input.data);
               return x;
           }
       
       
           else
       {
          
         return sum( getNumericValue(input.left.data), getNumericValue(input.right.data),input.data) ;
       }
        
    }




public static int sum(int q,int w,char c)
{
  
   if(c == '+')
   {
       
      return q+w;
   }
   else if(c == '-')
   {
       
       return q-w;
   }
   else if(c =='*')
   {
       
       return q*w;
   }
   else 
   {
       return q/w;
   }
}
	
	
	
	
}
