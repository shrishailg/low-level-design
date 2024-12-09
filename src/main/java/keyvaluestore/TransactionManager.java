package main.java.keyvaluestore;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TransactionManager<K,V> {
    private final KeyValueStore<K, V> cache;
    private final List<TransactionOperation<K, V>> log;
//    private final Stack<TransactionOperation<K, V>> transactionStack;

    public TransactionManager(KeyValueStore<K, V> cache) {
        this.cache = cache;
        log = new ArrayList<>();
//        transactionStack = new Stack<>();
    }

    public void beginTransaction() {
        log.clear();
    }

//    public void trackTransaction() {
//        TransactionOperation<K,V> transactionOperation = transactionStack.peek();
//
//    }
//
//    public void beginTransactionV2() {
//        TransactionOperation<K,V> transactionOperation = new TransactionOperation<>()
//    }

    public void add(K key, V value) {
        log.add(new TransactionOperation<>(OperationType.ADD, key, value));
    }

    public void update(K key, V newValue) {
        log.add(new TransactionOperation<>(OperationType.UPDATE, key, newValue));
    }

    public void remove(K key) {
        log.add(new TransactionOperation<>(OperationType.REMOVE, key, null));
    }

    public void commit() {
        for (var transactionOperation : log) {
            switch (transactionOperation.getType()) {
                case ADD, UPDATE:
                    cache.put(transactionOperation.getKey(), transactionOperation.getValue());
                    break;
                case REMOVE:
                    cache.remove(transactionOperation.getKey());
                    break;
            }
        }
        log.clear();
    }

    public void rollback() {
        log.clear();
    }
}
