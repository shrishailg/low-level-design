package main.java.parkinglot.parkingfloor;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    Map<Integer, List<ParkingFloor>> parkingFloors;

    public ParkingLot(Map<Integer, List<ParkingFloor>> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public Map<Integer, List<ParkingFloor>> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(Map<Integer, List<ParkingFloor>> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }
}
