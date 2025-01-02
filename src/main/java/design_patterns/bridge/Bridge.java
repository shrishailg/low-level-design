package main.java.design_patterns.bridge;

/*
Left this have to go through again
 */
// this pattern helps to decouple an abstraction from its implementation
// so that two can vary independently
public class Bridge {
}

abstract class Living {
    abstract void breath();
}

class Dog extends Living {

    @Override
    void breath() {
        System.out.println("dog breathing");
    }
}

class Fish extends Living {

    @Override
    void breath() {
        System.out.println("fish breathing");
    }
}
