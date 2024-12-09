package main.java.parkinglot.exception;

public class VehicleAlreadyAssignedException extends RuntimeException{

    public VehicleAlreadyAssignedException(String message) {
        super(message);
    }
}
