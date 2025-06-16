package main.java.concertbooking;

import main.java.concertbooking.exception.SeatNotAvailableException;

public class Seat {
    private String id;
    private String seatNumber;
    private SeatType seatType;
    private double price;
    private SeatStatus status;

    public Seat(String id, String seatNumber, SeatType seatType, double price) {
        this.id = id;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
        this.status = SeatStatus.AVAILABLE;
    }

    public synchronized void bookSeat() {
        if (status == SeatStatus.AVAILABLE) {
            status = SeatStatus.BOOKED;
        } else {
            throw new SeatNotAvailableException("Seat is already booked or reserved.");
        }
    }

    public synchronized void release() {
        if (status == SeatStatus.BOOKED || status == SeatStatus.RESERVED) {
            status = SeatStatus.AVAILABLE;
        }
    }

    public double getPrice() {
        return price;
    }


    public String getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public SeatStatus getStatus() {
        return status;
    }
}
