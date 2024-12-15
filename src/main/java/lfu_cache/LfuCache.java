package main.java.lfu_cache;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Least Frequently used
public class LfuCache<K,V> {
    private final HashMap<K, Node<K,V>> cache;
    private final TreeMap<Integer, LinkedList<K,V>> freqMap;
    private final Integer capacity;

    public LfuCache(Integer capacity1) {
        cache = new HashMap<>();
        freqMap = new TreeMap<>();
        capacity = capacity1;
    }

    public HashMap<K, Node<K, V>> getCache() {
        return cache;
    }

    //get the value
    public V get(K key){
        if (!cache.containsKey(key)) {
            return null;
        }

        Node<K,V> node = cache.get(key);

        LinkedList<K,V> linkedList = freqMap.get(node.getFreq());
        linkedList.remove(node);

        node.setFreq(node.getFreq()+1);
        linkedList.add(node);
        freqMap.put(node.getFreq(), linkedList);
        cache.put(key, node);

        return node.getValue();
    }

    //put the value
    public void put(K key, V value) {
        if (capacity <= 0) return;

        if (cache.containsKey(key)) {
            Node<K,V> node = cache.get(key);


            LinkedList<K,V> linkedList = freqMap.get(node.getFreq());
            linkedList.remove(node);

            node.setValue(value);
            linkedList.add(node);
            freqMap.put(node.getFreq(), linkedList);
            cache.put(key, node);
        }

        Node<K,V> newNode = new Node<>(key, value, 1);

        LinkedList<K,V> linkedList = freqMap.getOrDefault(newNode.getFreq(), new LinkedList<>());
        linkedList.add(newNode);
        freqMap.put(newNode.getFreq(), linkedList);
        cache.put(key, newNode);

        if (cache.size() > capacity) {
            evictNode();
        }
    }

    private void evictNode() {
        Map.Entry<Integer, LinkedList<K,V>> firstEntry = freqMap.firstEntry();
        Node<K,V> nodeTobeRemoved = firstEntry.getValue().removeFirst();
        cache.remove(nodeTobeRemoved.getKey());

        if (firstEntry.getValue().getHead() == null) {
            freqMap.remove(firstEntry.getKey());
        }

    }
}
