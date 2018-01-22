/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1;

import java.util.Stack;
import javafx.scene.Node;
import java.util.*;
import java.util.Scanner;
import javax.swing.JTree;
/**
 *
 * @author User
 */
public class Homework1 {
    
    public static Node tree;
    public static Stack<Character> sta = new Stack<Character>();
    /**
     * @param args the command line arguments
     */ 
    public static void main(String[] args) 
    {
         /*// Begin of arguments input sample
         
  		if (args.length > 0) {
  			String input = args[0];
  			if (input.equalsIgnoreCase("251-*32*+")) {
  				System.out.println("(2*(5-1))+(3*2)=14");
  			}
  		}*/
                 String ex = "251-*32*+"; 
                 int i =0;
                 do{
                    sta.push(ex.charAt(i));
                    i++;                    
                 }while(i < ex.length());
                 tree = new Node(sta.pop());
                 infix(tree); 
                 inorder(tree);
                 System.out.print( "= " + calculate(tree) );                 
            // End of arguments input sample
    }
    
    public static class Node
    {
        Character data;
        Node left; 
        Node right;		
        Node(char sth)
        {
           this.data=sth;
        }      
    }
    
    public static void inorder (Node n)
    {
        if(n.data == '+' || n.data == '-' || n.data == '*' || n.data == '/')
        {
            if(n!=tree) System.out.print("("); 
            inorder(n.left); 
            System.out.print(n.data);           
            inorder(n.right);
            if(n!=tree) System.out.print(")");    
           
         }else{
                if(n!=tree) System.out.print(n.data);
        }      
    }
    
    public static void infix (Node n)
    {
        if(n.data == '+' || n.data == '-' || n.data == '*' || n.data == '/')
             {
                 n.right = new Node(sta.pop()); infix(n.right);
                 n.left =  new Node(sta.pop()); infix(n.left);
             }
    }
   
    public static int calculate (Node n)           
    {        
        if( n.data == '+' ) return calculate(n.left) + calculate(n.right);     
        else if( n.data == '-' ) return calculate(n.left) - calculate(n.right);
        else if( n.data == '*' ) return calculate(n.left) * calculate(n.right);
        else if( n.data == '/' ) return calculate(n.left) / calculate(n.right);
        else  return Integer.parseInt(n.data.toString());       
    }   
}

    

