package main.java.parking_lot.parkingfloor;

public class Ticket {
    private String licenseNo;
    private Integer parkingLotId;
    private Integer parkingFloorNo;
    private Integer parkingFloorSlotId;

    public Ticket(Integer parkingLotId, Integer parkingFloorNo, Integer parkingFloorSlotId) {
        this.parkingFloorNo = parkingFloorNo;
        this.parkingFloorSlotId = parkingFloorSlotId;
        this.parkingLotId = parkingLotId;
    }

    public Integer getParkingLotId() {
        return parkingLotId;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setParkingLotId(Integer parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public Integer getParkingFloorNo() {
        return parkingFloorNo;
    }

    public void setParkingFloorNo(Integer parkingFloorNo) {
        this.parkingFloorNo = parkingFloorNo;
    }

    public Integer getParkingFloorSlotId() {
        return parkingFloorSlotId;
    }

    public void setParkingFloorSlotId(Integer parkingFloorSlotId) {
        this.parkingFloorSlotId = parkingFloorSlotId;
    }
}
