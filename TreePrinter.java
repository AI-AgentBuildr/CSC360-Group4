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

        // Guards against cycles below the root (e.g. R -> A -> B -> A)
        Set<TreeNode> visited = new HashSet<>();
        visited.add(root);

        Deque<StackFrame> stack = TreeTraversal.buildInitialStack(root);
        while (!stack.isEmpty()) {
            StackFrame frame = stack.pop();
            String connector = frame.isLast ? "└── " : "├── ";
            if (!visited.add(frame.node)) {
                System.out.println(frame.prefix + connector + frame.node.name
                        + " (cycle detected, skipping repeated subtree)");
                continue;
            }
            System.out.println(frame.prefix + connector + frame.node.name);
            TreeTraversal.pushChildren(stack, frame);
        }
    }
}
