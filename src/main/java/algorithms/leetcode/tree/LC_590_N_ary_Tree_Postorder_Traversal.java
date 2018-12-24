package algorithms.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class LC_590_N_ary_Tree_Postorder_Traversal {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) return res;
        for (Node node : root.children) {
            postorder(node);
        }
        res.add(root.val);
        return res;
    }
}
