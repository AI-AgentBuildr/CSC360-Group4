public class TreePrinterTest {
    public static void main(String[] args) {
        System.out.println("Test 1: Normal multi-level tree");
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        a.children.add(b);
        a.children.add(c);
        TreePrinter.printTree(a);

        System.out.println("\nTest 2: Root with no children");
        TreePrinter.printTree(new TreeNode("Solo"));

        System.out.println("\nTest 3: Null root");
        TreePrinter.printTree(null);

        System.out.println("\nTest 4: Long single-child chain");
        TreeNode chainA = new TreeNode("A");
        TreeNode chainB = new TreeNode("B");
        TreeNode chainC = new TreeNode("C");
        TreeNode chainD = new TreeNode("D");
        chainA.children.add(chainB);
        chainB.children.add(chainC);
        chainC.children.add(chainD);
        TreePrinter.printTree(chainA);

        System.out.println("\nTest 5: Wide tree (many children)");
        TreeNode root = new TreeNode("Root");
        root.children.add(new TreeNode("Child1"));
        root.children.add(new TreeNode("Child2"));
        root.children.add(new TreeNode("Child3"));
        root.children.add(new TreeNode("Child4"));
        TreePrinter.printTree(root);
    }
}
