package com.starlink.backend.lld.district;

import com.starlink.backend.lld.district.enums.SeatCategory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Client {
    public static void main(String[] args) {
        // 1. Create Movie
        Movie movie = new Movie(1, "Jawan", 180);

        // 2. Create Theater and Screen
        Theater theater = new Theater(1, "PVR Forum Mall", "Bangalore");
        Screen screen = new Screen(1);

        // 3. Add seats to screen
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat(1, 1, SeatCategory.GOLD));
        seats.add(new Seat(2, 1, SeatCategory.GOLD));
        seats.add(new Seat(3, 2, SeatCategory.SILVER));
        seats.add(new Seat(4, 2, SeatCategory.SILVER));
        seats.add(new Seat(5, 3, SeatCategory.PLATINUM));
        screen.setSeats(seats);

        // 4. Add screen to theater
        theater.addScreen(screen);

        // 5. Create Show
        Show show = new Show(1, movie, screen, new Date());
        theater.addShow(show);

        // 6. Book tickets
        List<Integer> seatIds = List.of(1, 2);  // Want to book seat 1 and 2
        if (show.bookSeats(seatIds)) {
            System.out.println("Seats booked successfully!");

            // 7. Process Payment
            Payment payment = new Payment();
            payment.processPayment(1000.0, "UPI");

            // 8. Create Booking
            List<Seat> bookedSeats = seats.stream()
                    .filter(s -> seatIds.contains(s.getSeatId()))
                    .collect(Collectors.toList());
            Booking booking = new Booking(1, show, bookedSeats, payment);

            System.out.println("Booking confirmed! Booking ID: " + booking.getBookingId());
        } else {
            System.out.println("Some seats are already booked!");
        }
    }
}