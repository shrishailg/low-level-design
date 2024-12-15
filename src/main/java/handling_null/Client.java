package main.java.handling_null;

public class Client {

    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle vehicle = vehicleFactory.getVehicleObject("Bike");

        System.out.println(vehicle.getFuelCapacity());
        System.out.println(vehicle.getSeatingCapacity());

    }
}
