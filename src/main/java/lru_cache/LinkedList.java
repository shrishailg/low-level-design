package main.java.lru_cache;

public class LinkedList<K,V> {
    Node<K,V> head;
    Node<K,V>  tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(Node<K,V> node) {
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
    }

    public void remove(Node<K,V> node) {
        if (node.getPrev() == null && node.getNext() == null) {
            head = null;
            tail = null;
            return;
        }

        if(node.getPrev() == null) {
            Node<K,V> next = node.getNext();
            next.setPrev(null);
            head = next;
            return;
        }

        if(node.getNext() == null) {
            Node<K,V> prev = node.getPrev();
            prev.setNext(null);
            tail = prev;
            return;
        }

        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    public Node<K,V> removeFirst() {
        if (head == null) {
            return null;
        }

        Node<K,V> first = head;
        head = head.getNext();
        head.setPrev(null);

        return first;
    }
}
