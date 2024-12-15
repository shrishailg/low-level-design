package main.java.design_patterns.singleton;

public class LazyInitialisation {

    private static LazyInitialisation lazyInitialisation;

    private LazyInitialisation() {

    }

    public static LazyInitialisation getInstance() {
        if (lazyInitialisation == null) {
            lazyInitialisation = new LazyInitialisation();
        }

        return lazyInitialisation;
    }
}

class LazyInitialisationClient{

    public static void main(String... args) {
        LazyInitialisation lazyInitialisation = LazyInitialisation.getInstance();
    }
}
