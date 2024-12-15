package main.java.parking_lot.vehicle;

public class Vehicle {
    String licenseNo;

    VehicleType vehicleType;
    String color;

    public Vehicle(String licenseNo, String color, VehicleType vehicleType) {
        this.licenseNo = licenseNo;
        this.vehicleType = vehicleType;
        this.color = color;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
