package main.java.design_patterns.decorator;

//This pattern helps us to add more functionality to existing object without changing its structure
public class Decorator {

    public static void main(String[] args) {
        BasePizza basePizza = new Extracheese(new MargheritaPizza());

        System.out.println(basePizza.cost());
    }
}


abstract class BasePizza {
    abstract int cost();
}

class FarmhousePizza extends BasePizza {

    @Override
    int cost() {
        return 10;
    }
}

class MargheritaPizza extends BasePizza {
    @Override
    int cost() {
        return 20;
    }
}
