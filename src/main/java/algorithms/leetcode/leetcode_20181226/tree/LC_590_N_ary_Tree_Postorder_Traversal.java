package algorithms.leetcode.leetcode_20181226.tree;

import java.util.*;

public class LC_590_N_ary_Tree_Postorder_Traversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return res;
        for (int i = 0; i < root.children.size(); ++i) {
            postorder(root.children.get(i));
        }
        res.add(root.val);
        return res;
    }

    public List<Integer> postorder_itr(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            for (Node node : root.children) {
                stack.push(node);
            }
        }
        Collections.reverse(res);
        return res;
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
};