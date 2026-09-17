import java.util.*;

public class TreeTraversal {
    public static Deque<StackFrame> buildInitialStack(TreeNode root) {
        Deque<StackFrame> stack = new ArrayDeque<>();
        List<TreeNode> children = root.children;
        for (int i = children.size() - 1; i >= 0; i--) {
            boolean isLast = (i == children.size() - 1);
            stack.push(new StackFrame(children.get(i), "", isLast));
        }
        return stack;
    }

    public static void pushChildren(Deque<StackFrame> stack, StackFrame frame) {
        String childPrefix = frame.prefix + (frame.isLast ? "    " : "│   ");
        List<TreeNode> children = frame.node.children;
        for (int i = children.size() - 1; i >= 0; i--) {
            boolean isLast = (i == children.size() - 1);
            stack.push(new StackFrame(children.get(i), childPrefix, isLast));
        }
    }
}