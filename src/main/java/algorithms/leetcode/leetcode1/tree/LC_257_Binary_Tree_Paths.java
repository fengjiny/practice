package algorithms.leetcode.leetcode1.tree;

import java.util.ArrayList;
import java.util.List;

public class LC_257_Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) searchBST(root, "", res);
        return res;
    }
    private void searchBST(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) result.add(path + root.val);
        if (root.left != null) searchBST(root.left, path + root.val + "->", result);
        if (root.right != null) searchBST(root.right, path + root.val + "->", result);
    }
}
