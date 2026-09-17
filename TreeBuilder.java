import java.util.*;

public class TreeBuilder {
    public static TreeNode buildTree(List<String[]> pairs) {
        Map<String, TreeNode> nodeMap = new HashMap<>();
        Set<String> childNodes = new HashSet<>();
        for (String[] pair : pairs) {
            String parentName = pair[0];
            String childName = pair[1];
            TreeNode parent = nodeMap.computeIfAbsent(parentName, TreeNode::new);
            TreeNode child = nodeMap.computeIfAbsent(childName, TreeNode::new);
            parent.children.add(child);
            childNodes.add(childName);
        }
        for (String name : nodeMap.keySet()) {
            if (!childNodes.contains(name)) return nodeMap.get(name);
        }
        return null;
    }
}