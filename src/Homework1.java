
public class Homework1 {


	public static void main(String[] args) {

		String pf = "251-*32*+";
		if(args.length>0)pf=args[0];
		TraversalTree eT = new TraversalTree(pf);
		eT.createExpressionTree();
		eT.inorder(eT.root);
		System.out.print("infix : ");
		eT.infix(eT.root);
		eT.calculate(eT.root);
		System.out.printf(" = " + eT.sum);
	}

}