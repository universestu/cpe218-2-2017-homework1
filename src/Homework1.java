public class Homework1 {

    public static Node root = null;
    public static String output;
    public String cmonBruh;

    public static void main(String[] args) {

        Function callFunction = new Function();

        // Begin of arguments input sample
        if (args.length > 0) {
            String input = args[0];

            for (int i = 0; i < input.length(); i++) {
                String value = input.substring(i, i + 1);

                Node N = new Node(value, null, null);

                callFunction.infix(N);
            }

            root = (Node) callFunction.stack.pop();
            output = callFunction.inorder(root);

            System.out.println(output.substring(1,output.length()-1) + "=" + callFunction.calculate(root));

//			if (input.equalsIgnoreCase("251-*32*+")) {
//				System.out.println("(2*(5-1))+(3*2)=14");
//			}
        }
        // End of arguments input sample

        // TODO: Implement your project here
    }


}

