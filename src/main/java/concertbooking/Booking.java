package main.java.concertbooking;

import java.util.List;

public class Booking {
    private String id;
    private Customer customer;
    private Concert concert;
    private List<Seat> seats;
    private double totalPrice;
    private BookingStatus status;


    public Booking(String id, Customer customer, Concert concert, List<Seat> seats) {
        this.id = id;
        this.customer = customer;
        this.concert = concert;
        this.seats = seats;
        this.totalPrice = calculateTotalPrice();
        this.status = BookingStatus.PENDING;
    }

    private double calculateTotalPrice() {
       return seats.stream().mapToDouble(Seat::getPrice).sum();
    }

    public void confirmBooking() {
        if (status == BookingStatus.PENDING) {
            status = BookingStatus.CONFIRMED;
            // Send booking confirmation to the user
            // ...
        }
    }

    public void cancelBooking() {
        if (status == BookingStatus.CONFIRMED) {
            status = BookingStatus.CANCELLED;
            seats.forEach(Seat::release);
            System.out.printf("Booking %s cancelled\n", id);
            // Send booking cancellation notification to the user
            // ...
        }
    }


    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Concert getConcert() {
        return concert;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
