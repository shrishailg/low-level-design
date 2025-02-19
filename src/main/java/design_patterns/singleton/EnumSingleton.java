package main.java.design_patterns.singleton;

public enum EnumSingleton {
    INSTANCE;

    private String something;

    public void process() {
        System.out.println("processing the data");
    }

    public synchronized String getSomething() {
        return something;
    }
}
