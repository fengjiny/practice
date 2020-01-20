package algorithms.leetcode.leetcode_20190902.list;

import java.util.HashMap;
import java.util.Map;

public class LC_138_Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node cur = head, clone;
        while(cur != null) {
            Node node = new Node(cur.val);
            Node next = cur.next;
            cur.next = node;
            node.next = next;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        clone = head.next;
        Node cloneHead = clone;
        while (cur != null && clone != null) {
            cur.next = cur.next.next;
            if (clone.next == null) break;
            clone.next = clone.next.next;
            cur = cur.next;
            clone = clone.next;
        }
        return cloneHead;
    }

    public static void main(String[] args) {
        Map m = new HashMap();

    }
}
