package main.java.concertbooking;

import main.java.concertbooking.exception.SeatNotAvailableException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ConcertBookingSystem {
    private static ConcertBookingSystem instance;
    private Map<String, Concert> concerts;
    private Map<String, Booking> bookings;
    private final Object lock = new Object();

    public ConcertBookingSystem() {
        concerts = new ConcurrentHashMap<>();
        bookings = new ConcurrentHashMap<>();
    }

    public static synchronized ConcertBookingSystem getInstance(){
        if (instance == null){
            instance = new ConcertBookingSystem();
        }

        return instance;
    }

    public void addConcert(Concert concert) {
        concerts.put(concert.getId(), concert);
    }

    public void getConcert(String concertID) {
        concerts.get(concertID);
    }

    public List<Concert> searchConcerts(String artist, String venue, LocalDateTime dateTime) {
        return concerts.values().stream().filter(concert -> concert.getPerformer() .equalsIgnoreCase(artist)
        && concert.getVenue().equalsIgnoreCase(venue) && concert.getDateTime().equals(dateTime)).collect(Collectors.toList());
    }

    public Booking bookTickets(Customer customer, Concert concert, List<Seat> seats) {
      synchronized (lock) {
          for (Seat seat : seats) {
              if (seat.getStatus() != SeatStatus.AVAILABLE) {
                  throw new SeatNotAvailableException("Seat " + seat.getSeatNumber() + " is not available.");
              }
          }

          seats.forEach(Seat::bookSeat);
          String bookingID = generateBookingID();
          Booking booking = new Booking(bookingID, customer, concert, seats);

          bookings.put(bookingID, booking);

          // Process payment
          processPayment(booking);

          // Confirm booking
          booking.confirmBooking();

          System.out.println("Booking " + booking.getId() + " - " + booking.getSeats().size() + " seats booked");

          return booking;
      }
    }

    public void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.cancelBooking();
            bookings.remove(bookingId);
        }
    }

    private void processPayment(Booking booking) {
        // Process payment for the booking
        // ...
    }

    private String generateBookingID() {
        return "BKG" + UUID.randomUUID();
    }

}
