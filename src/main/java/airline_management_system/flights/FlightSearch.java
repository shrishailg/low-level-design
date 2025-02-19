package main.java.airline_management_system.flights;


import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {
    private final List<Flight> flights;

    public FlightSearch(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        return flights.stream().filter(flight ->
                flight.getSource().equals(source) &&
                        flight.getSource().equals(destination) &&
                flight.getArrivalTime().equals(arrivalTime) &&
                flight.getDepartureTime().equals(departureTime)
                ).collect(Collectors.toList());
    }
}
