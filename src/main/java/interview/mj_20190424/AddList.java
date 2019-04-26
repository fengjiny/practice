package interview.mj_20190424;



import algorithms.ListNode;
import algorithms.Utils;

import java.util.Stack;

/**
 * 猿辅导面试算法题
 * 单链表表示的大整数+1
 * list每一个节点代表一个整数的一位，对这个list进行 + 1操作.
 * 例如： 1->2->-3->4  + 1  结果为 1->2->-3->5
 */


public class AddList {
    public ListNode add(ListNode head) {
        if (head == null) return head;
        Stack<Integer> s = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            s.push(cur.val);
            cur = cur.next;
        }
        ListNode dummy = new ListNode(0);
        int sum = 1;
        while (!s.isEmpty()) {
            sum += s.pop();
            ListNode node = new ListNode(sum%10);
            node.next = dummy.next;
            dummy.next = node;
            sum /= 10;
        }
        if (sum == 1) {
            ListNode node = new ListNode(1);
            node.next = dummy.next;
            dummy.next = node;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = Utils.createList(new int[]{8,9,9,9,9});
        Utils.printList(head);
        ListNode newHead = new AddList().add(head);
        Utils.printList(newHead);
    }


}

