package main.java.design_patterns.flyweight;

public class Cat implements Animal{
    String name  = null;
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printAnimalAttributes() {
        System.out.println("me of animal is ");
    }
}
