package algorithms.leetcode_20181226.tree;

import java.util.ArrayList;
import java.util.List;

public class LC_257_Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) searchBT(root, "", res);
        return res;
    }
    private void searchBT(TreeNode root, String path, List<String> res) {
        if (root.left == null && root.right == null) res.add(path + root.val);
        if (root.left != null) searchBT(root.left, path + root.val +"->", res);
        if (root.right != null) searchBT(root.right, path + root.val +"->", res);
    }
}
