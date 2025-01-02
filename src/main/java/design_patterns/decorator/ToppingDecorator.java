package main.java.design_patterns.decorator;

abstract class ToppingDecorator extends BasePizza{
}

class Extracheese extends ToppingDecorator {
    private final BasePizza basePizza;

    public Extracheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    int cost() {
        return basePizza.cost() + 100;
    }
}

class Mashroom extends ToppingDecorator{
    private final BasePizza basePizza;

    public Mashroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    int cost() {
        return basePizza.cost() + 200;
    }
}

