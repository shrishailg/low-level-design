package main.java.airlinemanagementsystem.booking;

import main.java.airlinemanagementsystem.Passenger;
import main.java.airlinemanagementsystem.flights.Flight;
import main.java.airlinemanagementsystem.seat.Seat;

public class Booking {
    private final String bookingId;
    private Passenger passenger;
    private Seat seat;
    private Flight flight;
    private final double price;
    private BookingStatus bookingStatus;

    public Booking(String bookingId, Passenger passenger, Seat seat, Flight flight, double price) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.seat = seat;
        this.flight = flight;
        this.bookingStatus = BookingStatus.CONFIRMED;
        this.price = price;
    }

    public void cancelBooking() {
        this.bookingStatus = BookingStatus.CANCELLED;
    }

    public String getBookingId() {
        return bookingId;
    }


    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }
}
