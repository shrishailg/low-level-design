package main.java.keyvaluestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class KeyValueStore<K, V> {
    private final Map<K, V> cache;
    private final ReentrantLock lock;

    public KeyValueStore() {
        cache = new HashMap<>();
        lock = new ReentrantLock();
    }

    public void put(K key, V value) {
        lock.lock();
        try {
            cache.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public V get(K key) {
        lock.lock();
        try {
            return cache.get(key);
        } finally {
            lock.unlock();
        }
    }

    public void remove(K key) {
        lock.lock();
        try {
            cache.remove(key);
        } finally {
            lock.unlock();
        }
    }
}

