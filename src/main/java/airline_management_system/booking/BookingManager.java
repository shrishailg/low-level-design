package main.java.airline_management_system.booking;


// book flight
// cancel flight

import main.java.airline_management_system.Passenger;
import main.java.airline_management_system.flights.Flight;
import main.java.airline_management_system.seat.Seat;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BookingManager {
    private final HashMap<String, Booking> flightBookings;
    private final AtomicInteger bookingCounter = new AtomicInteger(0);
    private final Object lock;

    public BookingManager() {
        flightBookings = new HashMap<>();
        lock = new Object();
    }

    public Booking bookFlight(Passenger passenger, Flight flight, Seat seat, double price) {
        String bookingId = generateBookingId();
        Booking booking = new Booking(bookingId, passenger, seat, flight, price);
        synchronized (lock) {
            flightBookings.put(bookingId, booking);
        }

        return booking;
    }

    public Booking cancelBooking(String bookingID) {
        synchronized (lock) {
            Booking booking = flightBookings.get(bookingID);
            if (flightBookings.get(bookingID) != null) {
                booking.cancelBooking();
            }
            return booking;
        }
    }

    private String generateBookingId() {
        int bookingID = bookingCounter.incrementAndGet();
        return "BKG-" + System.currentTimeMillis() + String.format("%06d", bookingID);
    }
}
