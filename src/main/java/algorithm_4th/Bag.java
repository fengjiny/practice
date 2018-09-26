package algorithm_4th;


import java.util.Iterator;

public class Bag<Item> implements Iterator<Item> {
    private Node first;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next() {
        return null;
    }

    private class Node {
        Item item;
        Node next;
    }
    public void add(Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {}
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
