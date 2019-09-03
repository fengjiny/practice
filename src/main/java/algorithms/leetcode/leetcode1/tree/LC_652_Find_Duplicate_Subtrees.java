package algorithms.leetcode.leetcode1.tree;

import java.util.*;

public class LC_652_Find_Duplicate_Subtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) return list;
        Map<String, Integer> resMap = new HashMap<>();
        postOrder(root, resMap, list);
        return list;
    }
    private String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(",");
        sb.append(postOrder(root.left, map, list)).append(",");
        sb.append(postOrder(root.right, map, list));
        String serial = sb.toString();
        if (map.getOrDefault(serial, 0) == 1) {
            list.add(root);
        }
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}
