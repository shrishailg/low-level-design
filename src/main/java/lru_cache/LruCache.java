package main.java.lru_cache;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

// time complexity O(1) for both put and get
// space complexity O(N)
public class LruCache<K,V> {
    private final HashMap<K,Node<K,V>> cache;
    private final LinkedList<K,V> linkedList;
    private Integer size;
    private final Integer maxSize;
    private final ReentrantLock reentrantLock;

    public LruCache(Integer maxSize) {
        this.cache = new HashMap<>();
        this.linkedList = new LinkedList<>();
        this.size = 0;
        this.maxSize = maxSize;
        reentrantLock = new ReentrantLock();
    }

    // get value from the cache
    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }

        Node<K,V> node = cache.get(key);
        linkedList.remove(node);
        linkedList.add(node);
        return node.getValue();
    }

    // put value to the cache
    public void put(K key, V value) {
        //if key is already present
        reentrantLock.lock();
        if (cache.containsKey(key)) {
            Node<K,V> node = cache.get(key);
            node.setValue(value);
            linkedList.remove(node);
            cache.put(key, node);
            linkedList.add(node);
            size++;
            reentrantLock.unlock();
            return;
        }

        Node<K,V> node = new Node<>(key, value);

        // if key not present
        if (size >= maxSize) {
            Node<K,V> nodeTobeRemoved = linkedList.removeFirst();
            linkedList.add(node);
            cache.remove(nodeTobeRemoved.getKey());
            cache.put(key, node);
            reentrantLock.unlock();
            return;
        }

        cache.put(key, node);
        linkedList.add(node);
        size++;
        reentrantLock.unlock();
    }

    // delete value from the cache
    public void delete(K key, V value) {
        Node<K,V> node = new Node<>(key, value);
        reentrantLock.lock();
        linkedList.remove(node);
        cache.remove(key);
        reentrantLock.lock();
        size--;
    }

    public HashMap<K, Node<K, V>> getCache() {
        return this.cache;
    }
}
