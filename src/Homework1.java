import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.ToolTipManager;
import javax.swing.ImageIcon;
import javax.swing.Icon;

import java.net.URL;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Component;



public class Homework1 extends JPanel implements TreeSelectionListener {
		private JEditorPane htmlPane;
		private JTree tree;
		private URL helpURL;
		private static boolean DEBUG = false;
	
		public Homework1(Node n) {
			super(new GridLayout(1,0));

			       //Create the nodes.
				   DefaultMutableTreeNode top = createNodes(n);

				   //Create a tree that allows one selection at a time.
				   tree = new JTree(top);
				   tree.getSelectionModel().setSelectionMode
						   (TreeSelectionModel.SINGLE_TREE_SELECTION);
		   
				   //Set the icon for leaf nodes.
				   ImageIcon Icon = createImageIcon("middle.gif");
				   if (Icon != null) {
					   DefaultTreeCellRenderer render = new DefaultTreeCellRenderer();
					   render.setClosedIcon(Icon);
					   render.setOpenIcon(Icon);
					   tree.setCellRenderer(render);
				   } else {
					   System.err.println("icon missing; using default.");
				   }
		   
				
				   tree.addTreeSelectionListener(this);
		   
	
				   JScrollPane treeView = new JScrollPane(tree);
		   
			
				   htmlPane = new JEditorPane();
				   htmlPane.setEditable(false);
				   JScrollPane htmlView = new JScrollPane(htmlPane);
		   
				
				   JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
				   splitPane.setTopComponent(treeView);
				   splitPane.setBottomComponent(htmlView);
		   
				   Dimension minimumSize = new Dimension(100, 50);
				   htmlView.setMinimumSize(minimumSize);
				   treeView.setMinimumSize(minimumSize);
				   splitPane.setDividerLocation(100); 
		   
				   splitPane.setPreferredSize(new Dimension(500, 300));
		   
				  
				   add(splitPane);
			   }
			    /** Returns an ImageIcon, or null if the path was invalid. */
				protected static ImageIcon createImageIcon(String path) {
					java.net.URL imgURL = Homework1.class.getResource(path);
					if (imgURL != null) {
						return new ImageIcon(imgURL);
					} else {
						System.err.println("Couldn't find file: " + path);
						return null;
					}
				}
		   
			   /** Required by TreeSelectionListener interface. */
			   public void valueChanged(TreeSelectionEvent e) {
				   DefaultMutableTreeNode node = (DefaultMutableTreeNode)
						   tree.getLastSelectedPathComponent();
		   
				   if (node == null) return;
		   
				   Object nodeInfo = node.getUserObject();
				   NodeInfo n = (NodeInfo) nodeInfo;
				   htmlPane.setText(ans);
			   }
		   
			   private DefaultMutableTreeNode createNodes(Node top) {
				   DefaultMutableTreeNode node = new DefaultMutableTreeNode(top);
				   if (top.Left == null) {
					   return node;
				   }

				   DefaultMutableTreeNode leftNode = createNodes(top.Left);
				   DefaultMutableTreeNode RightNode = createNodes(top.Right);
				   node.add(leftNode);
				   node.add(RightNode);

				   return node;

			   }
		   
			  
		   
			   /**
				* Create the GUI and show it.  For thread safety,
				* this method should be invoked from the
				* event-dispatching thread.
				*/
			   private static void createAndShowGUI(Node n) {
				   //Create and set up the window.
				   JFrame frame = new JFrame("Binary Tree Calculator");
				   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
				   //Create and set up the content pane.
				   Homework1 newContentPane = new Homework1(n);
				   newContentPane.setOpaque(true); //content panes must be opaque
				   frame.setContentPane(newContentPane);
		   
				   //Display the window.
				   frame.pack();
				   frame.setVisible(true);
			   }
		   
			   public class NodeInfo {
				public String data;
				public int value;
		
				public NodeInfo(String data, int value) {
					this.data = data;
					this.value = value;
				}
		
			
			}

	static Stack st = new Stack();
	public static void main(String[] args) {
		// Begin of arguments input sample
		String input = args[0];
		String ans = "";
		Node tempNode = new Node(null,null,null);
		if (args.length > 0) {
	
			String line = "This order was placed for QT3000! OK?";
			String pattern = "[0-9]";
			Pattern r = Pattern.compile(pattern);
	  
			
			
            for (int i = 0; i < input.length(); i++) {
				Matcher m = r.matcher(String.valueOf(input.charAt(i)));
                if (m.find()) {
                    st.push(new Node(String.valueOf(input.charAt(i)),null,null));
                } else {
					tempNode = new Node(String.valueOf(input.charAt(i)),null,null);
                    tempNode.Right = (Node) st.pop();
                    tempNode.Left = (Node) st.pop();
					st.push(tempNode);
				}
				
			}
			
			ans = Infix(tempNode) + "=" + Calculate(tempNode);
			System.out.println(ans);

			Node finalNode = tempNode;
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI(finalNode);
				}
			});
		}
	
	}

	

	public static String Infix(Node n) {
        String s = Inorder(n);
		if (s.length() > 1){
            return s.substring(1, s.length() - 1);}
        else {
			return s;
		}
	}

	public static String Inorder(Node n) {
		String postfix = "";
			if (n.Left == null && n.Right == null){
				return n.root; 
			}else {
             if (n.Left != null) {
                postfix += "(" + Inorder(n.Left);
			}
			postfix += n.root;
             if (n.Right != null) {
                postfix += Inorder(n.Right) + ")";
            }
			}
        return postfix;
	}


	public static int Calculate(Node n) {
        if (n.Left == null && n.Right == null) {
            return Integer.parseInt(n.root);
        } else {
			int leftNum = Calculate(n.Left);
			int RightNum = Calculate(n.Right);
            switch (n.root) {
                case "+":
                    return  leftNum + RightNum;
                case "-":
                    return leftNum - RightNum;
                case "*":
                    return leftNum * RightNum;
				case "/":
                    return leftNum / RightNum;
            }
        }
		return 0;
    }

	
	public static class Node{
		private Node Left;
		private Node Right;
		private String root;

		public Node(){
			root = null;
			Left = null;
			Right = null;
		}

		public Node(String n, Node l, Node r) {
			root = n;
			Left = l;
			Right = r;
		}
	
	}
	
}

