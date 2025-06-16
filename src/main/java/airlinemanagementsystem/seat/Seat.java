package main.java.airlinemanagementsystem.seat;

public class Seat {
    private String seatId;
    private String seatNumber;
    private String flightId;
    private SeatStatus seatStatus;
    private SeatType seatType;

    public Seat(String seatNumber, SeatStatus seatStatus, SeatType seatType, String flightId) {
        this.seatNumber = seatNumber;
        this.seatStatus = seatStatus;
        this.seatType = seatType;
        this.flightId = flightId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
