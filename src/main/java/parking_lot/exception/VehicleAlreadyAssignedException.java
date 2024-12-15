package main.java.parking_lot.exception;

public class VehicleAlreadyAssignedException extends RuntimeException{

    public VehicleAlreadyAssignedException(String message) {
        super(message);
    }
}
