import java.util.*;

public class TreePrinter {
    public static void printTree(TreeNode root) {
        System.out.println(root.name);
        Deque<StackFrame> stack = TreeTraversal.buildInitialStack(root);
        while (!stack.isEmpty()) {
            StackFrame frame = stack.pop();
            String connector = frame.isLast ? "└── " : "├── ";
            System.out.println(frame.prefix + connector + frame.node.name);
            TreeTraversal.pushChildren(stack, frame);
        }
    }
}
