package algorithms.leetcode_20181226.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC_589_N_ary_Tree_Preorder_Traversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return res;
        res.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }
        return res;
    }

    public List<Integer> preorder_itr(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            root = s.pop();
            res.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; --i) {
                s.push(root.children.get(i));
            }
        }
        return res;
    }
}
