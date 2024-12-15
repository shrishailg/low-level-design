package main.java.lfu_cache;

public class Node<K,V> {
   private K key;
    private V value;
    private Integer freq;
    private Node<K,V> prev;
    private Node<K,V> next;


    public Node(K key, V value, Integer freq) {
        this.key = key;
        this.value = value;
        this.freq = freq;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public Integer getFreq() {
        return freq;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    public Node<K, V> getPrev() {
        return prev;
    }

    public void setPrev(Node<K, V> prev) {
        this.prev = prev;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
}
