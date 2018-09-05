package algorithms.jianzhi;

import java.util.ArrayList;

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode pre = null;
        while (listNode != null) {
            ListNode next = listNode.next;
            listNode.next = pre;
            pre = listNode;
            listNode = next;
        }
        while (pre != null) {
            res.add(pre.val);
            pre = pre.next;
        }
        return res;
    }
}
