/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;
import java.util.*;
import java.util.Stack;
import java.util.Scanner;
import javafx.scene.Node;
import javax.swing.JTree;

/**
 *
 * @author User
 */
 /**
     * @param args the command line arguments
     */
    
public class Homework1 {
    public static void main(String[] args) {
       // Begin of arguments input sample
		if (args.length > 0) {
			String input = args[0];
			if (input.equalsIgnoreCase("251-*32*+")) {
				System.out.println("(2*(5-1))+(3*2)=14");
			}
		}
		// End of arguments input sample
	
		// TODO: Implement your project here
    }
    
    Stack<Character> stack = new Stack<Character>();
    public static class Node
	{
		int data;
		Node left;
		Node right;
		Node(int data)
		{
			this.data=data;
		}
	}
    
    public static void infix(Node n)
    {
        // เรียงแบบ การคำนวณปกติ
         
        char[] in = n.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder out = new StringBuilder();

    for (int i = 0; i < in.length; i++)
        switch (in[i]) {
        case '+':
        case '-':
            while (!stack.empty()
                    && (stack.peek() == '*' || stack.peek() == '/'))
                out.append(' ').append(stack.pop());
        case '*':
        case '/':
            out.append(' ');
        case '(':
            stack.push(in[i]);
        case ' ':
            break;
        case ')':
            while (!stack.empty() && stack.peek() != '(')
                out.append(' ').append(stack.pop());
            if (!stack.empty())
                stack.pop();
            break;
        default:
            out.append(in[i]);
            break;
        }

    while (!stack.isEmpty())
        out.append(' ').append(stack.pop());


    }
    
    public  void Caculate(Node n)
    {   
        //การคำนวณ  คิดแบบเจอเครื่องหมานนี้ทำอะไรยังไง   
        String cleanExpr = cleanExpr(expr);
		LinkedList<Double> stack = new LinkedList<Double>();
		//System.out.println("Input\tOperation\tStack after");
		for(String token:cleanExpr.split("\\s")){
			System.out.print(token+"\t");
			Double tokenNum = null;
			try{
				tokenNum = Double.parseDouble(token);
			}catch(NumberFormatException e){}
			if(tokenNum != null){		
				stack.push(Double.parseDouble(token+""));
			}else if(token.equals("*")){
				double secondOperand = stack.pop();
				double firstOperand = stack.pop();
				stack.push(firstOperand * secondOperand);
			}else if(token.equals("/")){
				double secondOperand = stack.pop();
				double firstOperand = stack.pop();
				stack.push(firstOperand / secondOperand);
			}else if(token.equals("-")){
				double secondOperand = stack.pop();
				double firstOperand = stack.pop();
				stack.push(firstOperand - secondOperand);
			}else if(token.equals("+")){			
				double secondOperand = stack.pop();
				double firstOperand = stack.pop();
				stack.push(firstOperand + secondOperand);
			}else if(token.equals("^")){		
				double secondOperand = stack.pop();
				double firstOperand = stack.pop();
				stack.push(Math.pow(firstOperand, secondOperand));
			}else{//just in case
				System.out.println("Error");
				return;
			}
			System.out.println(stack);
		}
		System.out.println(stack.pop() + "Final answer: ");
    
    }
    public  void inorder(Node n)
    {
        //คิดแบบ บีทรี
       	// Recursive Solution
		if(n !=  null) {
			inorder(n.left);
			//Visit the node by Printing the node data  
			System.out.printf("%d ",n.data);
			inorder(n.right);
		}
	}
    }
   
    

