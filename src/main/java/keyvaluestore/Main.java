package main.java.keyvaluestore;

public class Main {

    public static void main(String[] args) {
        KeyValueStore<String, Integer> keyValueStore = new KeyValueStore<>();
        TransactionManager<String,Integer> txManager = new TransactionManager<>(keyValueStore);

        txManager.beginTransaction();
        txManager.add("key1", 10);
        txManager.update("key2", 20);
        txManager.remove("key3");

        try {
            txManager.commit();
            System.out.println("Transaction committed successfully!");
        } catch (Exception e) {
            txManager.rollback();
            System.out.println("Transaction rolled back due to error: " + e.getMessage());
        }
    }
}
