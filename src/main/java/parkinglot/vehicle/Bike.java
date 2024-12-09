package main.java.parkinglot.vehicle;

public class Bike extends Vehicle{

    public Bike(String licenseNo, String color) {
        super(licenseNo,color, VehicleType.BIKE);
    }
}
