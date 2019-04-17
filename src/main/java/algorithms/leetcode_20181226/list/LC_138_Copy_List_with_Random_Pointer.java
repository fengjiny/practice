package algorithms.leetcode_20181226.list;

public class LC_138_Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node cur = head, clone;
        while (cur != null) {
            Node node = new Node();
            node.val = cur.val;
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        clone = head.next;
        Node cloneHead = head.next;
        while (cur != null && clone != null) {
            cur.next =  cur.next.next;
            if (clone.next == null) break;
            clone.next = clone.next.next;
            cur = cur.next;
            clone = clone.next;
        }
        return cloneHead;
    }
}

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}