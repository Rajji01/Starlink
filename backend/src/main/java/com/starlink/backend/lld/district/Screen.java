package com.starlink.backend.lld.district;

import com.starlink.backend.lld.district.enums.SeatCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Screen {
    private int screenId;
    List<Seat> seats;

    // Constructor
    public Screen(int screenId) {
        this.screenId = screenId;
        this.seats = new ArrayList<>();
    }
    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
    // ✅ Business Logic: Get available seats for a show
    public List<Seat> getAvailableSeats(Show show) {
        List<Integer> bookedSeatIds = show.getBookedSeats();
        return seats.stream()
                .filter(seat -> !bookedSeatIds.contains(seat.getSeatId()))
                .collect(Collectors.toList());
    }

    // ✅ Business Logic: Check if seats are available
    public boolean areSeatsAvailable(Show show, List<Integer> requestedSeatIds) {
        List<Integer> bookedSeatIds = show.getBookedSeats();
        return requestedSeatIds.stream().noneMatch(bookedSeatIds::contains);
    }

    // ✅ Business Logic: Get seats by category
    public List<Seat> getSeatsByCategory(SeatCategory category) {
        return seats.stream()
                .filter(seat -> seat.getSeatCategory() == category)
                .collect(Collectors.toList());
    }

}
