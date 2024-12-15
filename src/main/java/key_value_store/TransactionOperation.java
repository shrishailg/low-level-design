package main.java.key_value_store;

public  class TransactionOperation<K, V> {
    private final OperationType type;
    private final K key;
    private final V value;

    public TransactionOperation(OperationType type, K key, V value) {
        this.type = type;
        this.key = key;
        this.value = value;
    }

    public OperationType getType() {
        return type;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
