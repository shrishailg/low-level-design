package main.java.parkinglot.vehicle;

public class Car extends Vehicle {

    public Car(String licenseNo, String color) {
        super(licenseNo, color, VehicleType.CAR);
    }
}
