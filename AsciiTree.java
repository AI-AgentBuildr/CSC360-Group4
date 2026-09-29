import java.util.List;
import java.util.Scanner;

public class AsciiTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String[]> relationships = InputHandler.readRelationships(scanner);
        TreeNode root = TreeBuilder.buildTree(relationships);

        System.out.println("ASCII Tree:");
        TreePrinter.printTree(root);
    }
}
