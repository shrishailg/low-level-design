package main.java.parking_lot.parkingfloor;

import main.java.parking_lot.exception.VehicleAlreadyAssignedException;
import main.java.parking_lot.vehicle.Vehicle;
import main.java.parking_lot.vehicle.VehicleType;

import java.util.*;

public class ParkingLotService {
    ParkingLot parkingLot;

    public ParkingLotService() {

    }

    public void createParkingLot(Integer parkingLotId, Integer noOfFloors, Integer noOfSlotsPerFloor) {
        //create parking lot with empty floors
        Map<Integer, List<ParkingFloor>> parkingFloors = new HashMap<>();

        //create parking floor
        List<ParkingFloor> parkingFloorList = new ArrayList<>();
        for (int floor = 0; floor < noOfFloors; floor++) {
            List<ParkingSlot> parkingSlots = new ArrayList<>();

            for (int slots = 0; slots < noOfSlotsPerFloor; slots++) {
                parkingSlots.add(new ParkingSlot(slots));
            }

            Map<Integer, List<ParkingSlot>> parkingFloorSlots = new HashMap<>();
            parkingFloorSlots.put(floor, parkingSlots);
            ParkingFloor parkingFloor = new ParkingFloor(floor, noOfFloors, parkingFloorSlots);
            parkingFloorList.add(parkingFloor);
        }

        parkingFloors.put(parkingLotId, parkingFloorList);

        parkingLot = new ParkingLot(parkingFloors);
    }

    public void parkVehicle(String licenseNo, VehicleType vehicleType, String color) {
        Vehicle vehicle = new Vehicle(licenseNo, color, vehicleType);

        parkingLot.getParkingFloors().forEach((parkingLotID, parkingFloorList) -> {
            Optional<ParkingFloor> availableParkingFloor = parkingFloorList.stream().filter(parkingFloor -> !parkingFloor.getIsFloorFull()).findFirst();

            if (availableParkingFloor.isEmpty()) {
                throw new RuntimeException("All the floors are full");
            }

            Integer floorId = availableParkingFloor.get().getFloorId();

            Optional<ParkingSlot> availableParkingSlot = availableParkingFloor.get().getParkingSlots().
                    get(floorId).stream().filter(ParkingSlot::getIsAvailable).findFirst();


            if (availableParkingSlot.isEmpty()) {
                throw new RuntimeException(String.format("no slots are available for the given floor id: %d", floorId));
            }

            try {
                availableParkingSlot.get().assignVehicle(vehicle);
            }catch (VehicleAlreadyAssignedException v) {
                parkVehicle(licenseNo, vehicleType, color);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        });
    }

    public void unParkVehicle(Ticket ticket) {

        List<ParkingFloor> parkingFloorList = parkingLot.getParkingFloors().get(ticket.getParkingFloorSlotId());
        Optional<ParkingFloor> parkingFloor = parkingFloorList.stream().
                filter(parkingFloor1 -> Objects.equals(parkingFloor1.getFloorId(), ticket.getParkingFloorNo())).findAny();

        if (parkingFloor.isEmpty()) {
            throw new RuntimeException("no parking floor found with parking floor id" + ticket.getParkingFloorNo());
        }

        List<ParkingSlot> parkingSlotList = parkingFloor.get().getParkingSlotsForFloor(parkingFloor.get().getFloorId());

        Optional<ParkingSlot> parkingSlot =  parkingSlotList.stream().filter(parkingSlot1 ->
                parkingSlot1.getParkingSlotID().equals(ticket.getParkingFloorSlotId())).findAny();

        if (parkingSlot.isEmpty()) {
            throw new RuntimeException("no parking slot found with slot id" + ticket.getParkingFloorSlotId());
        }

        if (!Objects.equals(parkingSlot.get().getVehicle().getLicenseNo(), ticket.getLicenseNo())) {
            throw new RuntimeException("parking slot and vehicle mismatch");
        }

        parkingSlot.get().unAssignVehicle();
    }


}
