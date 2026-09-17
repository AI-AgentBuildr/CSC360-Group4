public class StackFrame {
    TreeNode node;
    String prefix;
    boolean isLast;

    public StackFrame(TreeNode node, String prefix, boolean isLast) {
        this.node = node;
        this.prefix = prefix;
        this.isLast = isLast;
    }
}