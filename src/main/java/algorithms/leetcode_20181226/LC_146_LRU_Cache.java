package algorithms.leetcode_20181226;

import java.util.Hashtable;

public class LC_146_LRU_Cache {

    private int count, capacity;
    private Node head;
    private Node tail;
    private Hashtable<Integer, Node> cache = new Hashtable();

    public LC_146_LRU_Cache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new Node();
        head.pre = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node == null) {
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;

            add(newNode);
            cache.put(key, newNode);
            ++count;
            if (count > capacity) {
                Node last = delTail();
                cache.remove(last.key);
                --count;
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }


    class Node {
        int key;
        int val;
        Node pre;
        Node next;
    }



    private void add(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(Node node) {
        remove(node);
        add(node);
    }

    private Node delTail() {
        Node res = tail.pre;
        remove(res);
        return res;
    }
}
