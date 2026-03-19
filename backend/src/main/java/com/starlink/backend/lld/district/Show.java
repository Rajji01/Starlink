package com.starlink.backend.lld.district;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Show {
    private int showid;
    private Movie movie;
    private Screen screen;
    private Date startTime;
    private List<Integer> bookedSeats;  // Changed to Integer for seat IDs

    public Show(int showid, Movie movie, Screen screen, Date startTime) {
        this.showid = showid;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.bookedSeats = new ArrayList<>();  // Initialize empty
    }

    public int getShowid() {
        return showid;
    }

    public void setShowid(int showid) {
        this.showid = showid;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
    // ✅ Business Logic: Book seats
    public boolean bookSeats(List<Integer> seatIds) {
        // Check if any seat is already booked
        for (Integer seatId : seatIds) {
            if (bookedSeats.contains(seatId)) {
                return false;  // Seat already booked
            }
        }
        // Book all seats
        bookedSeats.addAll(seatIds);
        return true;
    }

    // ✅ Business Logic: Check if seat is available
    public boolean isSeatAvailable(int seatId) {
        return !bookedSeats.contains(seatId);
    }

    // ✅ Business Logic: Get available seat count
    public int getAvailableSeatCount() {
        return screen.getSeats().size() - bookedSeats.size();
    }
}
