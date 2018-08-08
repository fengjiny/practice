package algorithms.leetcode.tree;


public class LC_623_Add_One_Row_to_Tree {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = d == 1 ? root : null;
            newNode.right = d == 0 ? root :null;
            return newNode;
        }
        if (root != null && d >= 2) {
            root.left = addOneRow(root.left, v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }
}
