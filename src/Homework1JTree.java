import java.util.Stack;

import javax.swing.*;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.net.URL;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;

public class Homework1JTree extends JPanel
        implements TreeSelectionListener {

    public static Tree binaryTree;
    private JEditorPane htmlPane;
    private JTree tree;
    private URL helpURL;
    private static boolean DEBUG = false;

    //Optionally play with line styles.  Possible values are
    //"Angled" (the default), "Horizontal", and "None".
    private static boolean playWithLineStyle = false;
    private static String lineStyle = "Horizontal";

    //Optionally set the look and feel.
    private static boolean useSystemLookAndFeel = false;

    public Homework1JTree() {
        super(new GridLayout(1, 0));

        //Create the nodes.
        DefaultMutableTreeNode top =
                new DefaultMutableTreeNode(
                        new NodeInfo(binaryTree.root.data,
                                infix(binaryTree.root),
                                calculate(binaryTree.root)));
        createNodes(top);

        //Create a tree that allows one selection at a time.
        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Listen for when the selection changes.
        tree.addTreeSelectionListener(this);

        if (playWithLineStyle) {
            System.out.println("line style = " + lineStyle);
            tree.putClientProperty("JTree.lineStyle", lineStyle);
        }

        //Create the scroll pane and add the tree to it.
        JScrollPane treeView = new JScrollPane(tree);

        //Create the HTML viewing pane.
        htmlPane = new JEditorPane();
        htmlPane.setEditable(false);
        JScrollPane htmlView = new JScrollPane(htmlPane);

        //Add the scroll panes to a split pane.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setTopComponent(treeView);
        splitPane.setBottomComponent(htmlView);

        Dimension minimumSize = new Dimension(100, 50);
        htmlView.setMinimumSize(minimumSize);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(100);
        splitPane.setPreferredSize(new Dimension(500, 300));

        ImageIcon nodeIcon = createImageIcon("middle.gif");
        if (nodeIcon != null) {
            DefaultTreeCellRenderer renderer =
                    new DefaultTreeCellRenderer();
            renderer.setClosedIcon(nodeIcon);
            renderer.setOpenIcon(nodeIcon);
            tree.setCellRenderer(renderer);
        }
        //Add the split pane to this panel.
        add(splitPane);
    }

    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Homework1JTree.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }


    /**
     * Required by TreeSelectionListener interface.
     */
    public void valueChanged(TreeSelectionEvent e) {
//Returns the last path element of the selection.
//This method is useful only when the selection model allows a single selection.
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree.getLastSelectedPathComponent();

        if (node == null) {
            //Nothing is selected.
            return;
        }

        Object nodeInfo = node.getUserObject();

        // TODO: Set text by infix(node n)
        if (node.isLeaf()) {
            NodeInfo n = (NodeInfo) nodeInfo;
            htmlPane.setText(n.toString());
        } else {
            NodeInfo n = (NodeInfo) nodeInfo;
            htmlPane.setText(n.infixValue + "=" + n.value);
        }
    }

    public class NodeInfo {
        public String data;
        public String infixValue;
        public int value;

        public NodeInfo(String data, String infixValue, int value) {
            this.data = data;
            this.infixValue = infixValue;
            this.value = value;
        }

        public String toString() {
            return data;
        }

    }


    public void inorderTraversal(DefaultMutableTreeNode top, Node n) {
        if (n.leftChild != null) {
            DefaultMutableTreeNode node1 =
                    new DefaultMutableTreeNode(
                            new NodeInfo(n.data, infix(n.leftChild),
                                    calculate(n.leftChild)));
            top.add(node1);
            inorderTraversal(node1, n.leftChild);
        }

        if (n.rightChild != null) {
            DefaultMutableTreeNode node2 =
                    new DefaultMutableTreeNode(
                            new NodeInfo(n.data, infix(n.rightChild),
                                    calculate(n.rightChild)));
            top.add(node2);
            inorderTraversal(node2, n.rightChild);
        }
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode operator = null; // + - * /
        DefaultMutableTreeNode operand = null; // number

        inorderTraversal(top, binaryTree.root);
    }

    private static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("Couldn't use system look and feel.");
            }
        }

        //Create and set up the window.
        JFrame frame = new JFrame("Binary Tree Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new Homework1JTree());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        // Begin of arguments input sample
        if (args.length > 0) {
            String input = args[0];
            if (input.equalsIgnoreCase("251-*32*+")) {
                System.out.println("(2*(5-1))+(3*2)=14");
            }

            // End of arguments input sample

            // TODO: Implement your project here

            Stack st = new Stack();
            for (int i = 0; i < input.length(); i++) {
                char car = input.charAt(i);
                if (car >= '0' && car <= '9') {
                    st.push(new Node(car + ""));
                } else {
                    String first = "", second = "";
                    int firstNo, secondNo, cal;

                    Node parentNode = new Node(car + "");
                    parentNode.rightChild = (Node) st.pop();
                    parentNode.leftChild = (Node) st.pop();
                    st.push(parentNode);
                }
            }
            binaryTree = new Tree((Node) st.pop());
            System.out.println(infix(binaryTree.root));
            System.out.println(calculate(binaryTree.root));
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static String infix(Node n) {
        // transform postfix to infix
        String s = inorder(n);
        if (s.length() > 1)
            return s.substring(1, s.length() - 1);
        else return s;
    }


    public static String inorder(Node n) {
        // traversal leftTree > root > rightTree
        String s = "";
        if (n.leftChild == null && n.rightChild == null) {
            return n.data;
        } else {
            if (n.leftChild != null) {
                s += "(" + inorder(n.leftChild);
            }
            s += n.data;
            if (n.rightChild != null) {
                s += inorder(n.rightChild) + ")";
            }
        }
        return s;
    }

    public static int calculate(Node n) {
        // calculate postfix using stack
        if (n.leftChild == null && n.rightChild == null) {
            return Integer.parseInt(n.data);
        } else {
            switch (n.data) {
                case "+":
                    return calculate(n.leftChild) + calculate(n.rightChild);
                case "-":
                    return calculate(n.leftChild) - calculate(n.rightChild);
                case "*":
                    return calculate(n.leftChild) * calculate(n.rightChild);
                default:
                    return calculate(n.leftChild) / calculate(n.rightChild);
            }
        }
    }


    public static class Node extends DefaultMutableTreeNode {

        public Node leftChild, rightChild;
        public String data;

        public Node() {
            this.leftChild = null;
            this.rightChild = null;
            this.data = null;
        }

        public Node(String data) {
            this.data = data;
        }

        public Node(Node leftChild, Node rightChild, String data) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
            this.data = data;
        }

    }

    public static class Tree {

        public Node root;

        public Tree() {
            this.root = null;
        }

        public Tree(Node root) {
            this.root = root;
        }
    }


}
