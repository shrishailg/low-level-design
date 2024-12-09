package main.java.parkinglot.parkingfloor;

import main.java.parkinglot.exception.VehicleAlreadyAssignedException;
import main.java.parkinglot.vehicle.Vehicle;

public class ParkingSlot {
    private Integer parkingSlotID;
    //    ParkingSlotType parkingSlotType;
    private volatile boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSlot(Integer parkingSlotID) {
        this.parkingSlotID = parkingSlotID;
//        this.parkingSlotType = parkingSlotType;
        this.isAvailable = true;
    }

    public synchronized void assignVehicle(Vehicle vehicle) {
        if (this.isAvailable) {
            this.isAvailable = false;
            this.vehicle = vehicle;
            return;
        }

        throw new VehicleAlreadyAssignedException("vehicle already exists in the given slot number");
    }

    public synchronized void unAssignVehicle() {
        this.isAvailable = true;
        this.vehicle = null;
    }

    public Integer getParkingSlotID() {
        return parkingSlotID;
    }

    public void setParkingSlotID(Integer parkingSlotID) {
        this.parkingSlotID = parkingSlotID;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
