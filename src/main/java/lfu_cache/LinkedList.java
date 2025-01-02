package main.java.lfu_cache;


public class LinkedList<K,V> {
    private Node<K,V> head;
    private Node<K,V> tail;

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

    public Node<K, V> getHead() {
        return head;
    }

    public void setHead(Node<K, V> head) {
        this.head = head;
    }

    public Node<K, V> getTail() {
        return tail;
    }

    public void setTail(Node<K, V> tail) {
        this.tail = tail;
    }
}
