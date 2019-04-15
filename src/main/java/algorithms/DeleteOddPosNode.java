package algorithms;



public class DeleteOddPosNode {
    public ListNode deleteOdd(ListNode head) {
        if (head == null || head.next == null) return head;
        int count = 1;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            if ((count++ & 1) == 1) {
                cur.val = cur.next.val;
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        if (count % 1 == 1)
            cur.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = Utils.createList(new int[] {1,2,3,4,5,6,7});
        ListNode newHead = new DeleteOddPosNode().deleteOdd(head);
        Utils.printList(newHead);
    }
}
