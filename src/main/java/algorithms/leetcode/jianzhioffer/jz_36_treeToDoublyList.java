package algorithms.leetcode.jianzhioffer;

import algorithms.leetcode.TreeNode;

public class jz_36_treeToDoublyList {
    TreeNode head, pre;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return root;
        convert(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void convert(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        if (root.left != null) {
            convert(cur.left);
        }
        cur.left = pre;
        if (pre != null) {
            pre.right = cur;
        } else {
            head = cur;
        }
        pre = cur;
        if (cur.right != null) {
            convert(cur.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);
        new jz_36_treeToDoublyList().treeToDoublyList(root);
    }
}
