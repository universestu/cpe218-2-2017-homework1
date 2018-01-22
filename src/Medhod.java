


public class Medhod  {
	 Node root;
	    Node current;
	    int N=0;

	    public Medhod() {

	    }

	    public boolean isOperator(char a) {
	        if (a == '+' || a == '-' || a == '*' || a == '/') {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public void makeTree(Node node) {

	        if (root == null) {
	            root = node;
	            current = root;
	        } else if (isOperator(current.key)) {
	            if(!isOperator(node.key)){
	                String a = node.key + "";
	                node.value = Integer.parseInt(a);
	            }
	            if (current.right == null) {
	                current.right = node;
	                node.parent = current;
	                if (isOperator(current.right.key)) {
	                    current = current.right;
	                }

	            } else if (current.left == null) {
	                current.left = node;
	                node.parent = current.left;
	                if (isOperator(current.left.key)) {
	                    current = current.left;
	                }
	            } else {
	                current = current.parent;
	                makeTree(node);
	            }
	        }
	    }

	    public void makeTree(String s) {
	        for (int i = s.length() - 1; i >= 0; i--) {
	            makeTree(new Node(s.charAt(i)));
	        }
	    }

	    

	    public void inorder(){
	        inorder(root);
	    }
	    public void inorder(Node n) {
	        if (n == null) {//if have no node
	            return;
	        } else {//by algorithm
	            inorder(n.left);
	            if(n.left != null && n.right != null){
	                Calculate(n); //calculate value
	            }
	            inorder(n.right);
	        }
	    }
	    public void infix() {
	        infix(root);
	    }

	     public void infix(Node n) {
	        if (n == null) {//if have no node
	                return;
	        } else {//by algorithm
	                if(isOperator(n.key)&& n!=root){
	                    System.out.print("(");
	                }
	                infix(n.left);
	                System.out.print(n.key);
	                infix(n.right);
	                if(isOperator(n.key)&& n!=root ){
	                    System.out.print(")");
	                }
	            }
	        }

	     public void printResult(){
	        inorder();
	        System.out.print("="+root.value);
	     }

	    public void Calculate(Node n) {
	        if (n.key == '+') {
	            n.value = n.left.value + n.right.value;
	        } else if (n.key == '-') {
	            n.value = n.left.value - n.right.value;
	        } else if (n.key == '*') {
	            n.value = n.left.value * n.right.value;
	        } else if (n.key == '/') {
	            n.value = n.left.value / n.right.value;
	        }
	        }

	    }

    




