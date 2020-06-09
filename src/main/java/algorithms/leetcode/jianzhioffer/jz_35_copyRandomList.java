package algorithms.leetcode.jianzhioffer;



class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class jz_35_copyRandomList {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);
            node.next = cur.next;
            cur.next = node;
            cur = node.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        Node newHead = head.next;
        cur = newHead;
        while (head != null) {
            head.next = head.next.next;
            head = head.next;
            if (cur.next != null) {
                cur.next = cur.next.next;
                cur = cur.next;
            }
        }
        return newHead;
    }


    private int add() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        jz_35_copyRandomList jz_35_copyRandomList = new jz_35_copyRandomList();
        int i = jz_35_copyRandomList.add();
        System.out.println(i);
    }
}

