package algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_589_N_ary_Tree_Preorder_Traversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            List<Node> children = root.children;
            for (int i = children.size() - 1; i >= 0; -- i) {
                stack.push(children.get(i));
            }
        }
        return res;
    }
    private void helper(Node root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
    }
}




class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
