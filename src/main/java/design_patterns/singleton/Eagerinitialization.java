package main.java.design_patterns.singleton;


public class Eagerinitialization {
    //creating during class loading
    private static Eagerinitialization eagerinitialization = new Eagerinitialization();

    // so that nobody from outside calls ot
    private Eagerinitialization() {

    }

    public static Eagerinitialization getInstance() {
        System.out.println("in instance method");
        return eagerinitialization;
    }
}

class Client{
    public static void main(String... args) {
        Eagerinitialization eagerinitialization = Eagerinitialization.getInstance();
    }
}
