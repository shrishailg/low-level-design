package main.java.parking_lot.parkingfloor;

import java.util.*;

public class ParkingFloor {
    Integer floorId;
    Integer noFloors;
    boolean isFloorFull;
    Map<Integer, List<ParkingSlot>> parkingSlots;

    public ParkingFloor(Integer floorId, Integer noFloors, Map<Integer, List<ParkingSlot>> parkingSlots) {
        this.floorId = floorId;
        this.noFloors = noFloors;
        this.parkingSlots = parkingSlots;
        this.isFloorFull = false;
    }

    public void setIsFloorFull(boolean value) {
        isFloorFull = value;
    }

    public boolean getIsFloorFull() {
        return isFloorFull;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public void setNoFloors(Integer noFloors) {
        this.noFloors = noFloors;
    }

    public void setParkingSlots(Map<Integer, List<ParkingSlot>> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public List<ParkingSlot> getParkingSlotsForFloor(Integer floorId) {
       return parkingSlots.get(floorId);
    }

    public Integer getNoFloors() {
        return noFloors;
    }

    public Integer getFloorId() {
        return floorId;
    }

    public Map<Integer, List<ParkingSlot>> getParkingSlots() {
        return parkingSlots;
    }
}


