package main.java.handling_null;

public class Car implements Vehicle{
    @Override
    public Integer getFuelCapacity() {
        return 100;
    }

    @Override
    public Integer getSeatingCapacity() {
        return 4;
    }
}
