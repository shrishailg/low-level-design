package main.java.airline_management_system;


import main.java.airline_management_system.aircraft.Aircraft;
import main.java.airline_management_system.booking.Booking;
import main.java.airline_management_system.booking.BookingManager;
import main.java.airline_management_system.flights.Flight;
import main.java.airline_management_system.flights.FlightSearch;
import main.java.airline_management_system.payment.Payment;
import main.java.airline_management_system.payment.PaymentProcessor;
import main.java.airline_management_system.seat.Seat;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class AirlineManagementSystem {
    private final HashMap<String, Flight> flights;
    private final HashMap<String, Aircraft> aircrafts;
    private final BookingManager bookingManager;
    private final FlightSearch flightSearch;
    private final PaymentProcessor paymentProcessor;

    public AirlineManagementSystem(BookingManager bookingManager, FlightSearch flightSearch, PaymentProcessor paymentProcessor) {
        this.flights = new HashMap<>();
        this.aircrafts = new HashMap<>();
        this.bookingManager = bookingManager;
        this.flightSearch = flightSearch;
        this.paymentProcessor = paymentProcessor;
    }


    public void addFlight(Flight flight) {
        flights.put(flight.getFlightNumber(), flight);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight.getFlightNumber());
    }

    public void addAircraft(Aircraft aircraft) {
        aircrafts.put(aircraft.getId(), aircraft);
    }

    public void removeAircraft(Aircraft aircraft) {
        aircrafts.remove(aircraft.getId());
    }

    public Booking bookFlight(Passenger passenger, Flight flight, Seat seat, double price) {
       return bookingManager.bookFlight(passenger, flight, seat, price);
    }

    public void cancelFlight(String bookingId) {
        bookingManager.cancelBooking(bookingId);
    }

    public List<Flight> searchFlight(String source, String destination, LocalDateTime arrivalTime, LocalDateTime departureTime) {
        return flightSearch.searchFlights(source, destination, arrivalTime, departureTime);
    }

    public Payment processPayment(Payment payment) {
        return paymentProcessor.processPayment(payment);
    }
}
