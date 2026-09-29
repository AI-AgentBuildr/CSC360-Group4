import java.util.*;

public class TreePrinter {
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("(empty tree)");
            return;
        }

        System.out.println(root.name);

        if (root.children == null || root.children.isEmpty()) {
            return;
        }

        Deque<StackFrame> stack = TreeTraversal.buildInitialStack(root);
        while (!stack.isEmpty()) {
            StackFrame frame = stack.pop();
            String connector = frame.isLast ? "└── " : "├── ";
            System.out.println(frame.prefix + connector + frame.node.name);
            TreeTraversal.pushChildren(stack, frame);
        }
    }
}
