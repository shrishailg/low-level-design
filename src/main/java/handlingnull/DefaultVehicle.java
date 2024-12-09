package main.java.handlingnull;

public class DefaultVehicle implements Vehicle{
    @Override
    public Integer getFuelCapacity() {
        return 0;
    }

    @Override
    public Integer getSeatingCapacity() {
        return 0;
    }
}
