package main.java.airline_management_system.aircraft;

public class Aircraft {
    private String id;
    private String name;
    private String airline;
    private AircraftType aircraftType;

    public Aircraft(String id, String name, String airline, AircraftType aircraftType) {
        this.id = id;
        this.name = name;
        this.airline = airline;
        this.aircraftType = aircraftType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAirline() {
        return airline;
    }

    public AircraftType getAircraftType() {
        return aircraftType;
    }
}
