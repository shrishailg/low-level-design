package main.java.airlinemanagementsystem.aircraft;

public class Aircraft {
    private String id;
    private String name;
    private String model;
    private AircraftType aircraftType;

    public Aircraft(String id, String name, String model, AircraftType aircraftType) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.aircraftType = aircraftType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }
}
