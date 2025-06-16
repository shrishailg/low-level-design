package main.java.concertbooking;

import java.time.LocalDateTime;
import java.util.List;

public class Concert {
    private String id;
    private String name;
    private String description;
    private String venue;
    private String performer;
    private LocalDateTime dateTime;
    private List<Seat> seats;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getVenue() {
        return venue;
    }

    public String getPerformer() {
        return performer;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
