package main.java.design_patterns.singleton;

public class ConcurrentSingleton {
    private static ConcurrentSingleton concurrentSingleton;

    private ConcurrentSingleton() {
    }

    // this is also called as double checked locking of singleton pattern
    public static ConcurrentSingleton getInstance() {
        if (concurrentSingleton == null) {
            synchronized(ConcurrentSingletonClient.class) {
                // this check is required if two threads are already at this block, 1st thread already created but
                // 2nd thread should not create
                if (concurrentSingleton == null) {
                    System.out.println("Instantiating the class");
                    concurrentSingleton = new ConcurrentSingleton();
                }
            }
        }

        return concurrentSingleton;
    }
}


class ConcurrentSingletonClient {

    public static void main(String... args) {
        ConcurrentSingleton concurrentSingleton = ConcurrentSingleton.getInstance();
    }
}
