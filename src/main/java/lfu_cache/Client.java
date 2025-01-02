package main.java.lfu_cache;


public class Client {

    public static void main(String[] args) {
        LfuCache<String, String> lfuCache = new LfuCache<>(2);

        lfuCache.put("k1","v1");
        lfuCache.put("k2","v2");
        System.out.println(lfuCache.getCache());
        lfuCache.put("k3","v3");
        System.out.println(lfuCache.getCache());
        lfuCache.get("k2");
        lfuCache.get("k2");
        System.out.println(lfuCache.getCache());
        lfuCache.put("k4","v4");
        System.out.println(lfuCache.getCache());
    }
}
