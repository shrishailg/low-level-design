package main.java.lru_cache;

public class Client {

    public static void main(String[] args) {
        LruCache<String, String> lruCache = new LruCache<>(2);

        lruCache.put("k1","v1");
        lruCache.put("k2","v2");
        System.out.println(lruCache.getCache());
        lruCache.put("k3","v3");
        System.out.println(lruCache.getCache());
    }
}
