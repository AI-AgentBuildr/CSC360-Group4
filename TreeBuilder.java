import java.util.*;

public class TreeBuilder {
    public static TreeNode buildTree(List<String[]> pairs) {
        // LinkedHashMap keeps input order, so "first root" means first seen in the input
        Map<String, TreeNode> nodeMap = new LinkedHashMap<>();
        Set<String> childNodes = new HashSet<>();
        for (String[] pair : pairs) {
            String parentName = pair[0];
            String childName = pair[1];
            TreeNode parent = nodeMap.computeIfAbsent(parentName, TreeNode::new);
            TreeNode child = nodeMap.computeIfAbsent(childName, TreeNode::new);
            if (!parent.children.contains(child)) {
                parent.children.add(child);
            }
            childNodes.add(childName);
        }

        List<String> roots = new ArrayList<>();
        for (String name : nodeMap.keySet()) {
            if (!childNodes.contains(name)) roots.add(name);
        }

        // No root means every node is someone's child (e.g. a full cycle)
        if (roots.isEmpty()) return null;

        if (roots.size() > 1) {
            System.out.println("Warning: multiple roots found " + roots
                    + ", using only the first: " + roots.get(0));
        }
        return nodeMap.get(roots.get(0));
    }
}
