package algorithms;



public class DeleteOddPosNode {
    public ListNode deleteOdd(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode even = head.next, evenHead = even;
        while (even != null && even.next != null){
            even.next = even.next.next;
            even = even.next;
        }
        return evenHead;
    }

    public ListNode deleteEven(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        while (odd != null && odd.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = Utils.createList(new int[] {1,2,3,4,5,6,7});
//        interview.ListNode newHead = new DeleteOddPosNode().deleteOdd(head);
        ListNode newHead2 = new DeleteOddPosNode().deleteEven(head);
//        Utils.printList(newHead);
        Utils.printList(newHead2);
    }
}
