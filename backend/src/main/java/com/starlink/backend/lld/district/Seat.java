package com.starlink.backend.lld.district;

import com.starlink.backend.lld.district.enums.SeatCategory;

public class Seat {
    private int seatId;
    private int row;
    private SeatCategory seatCategory;
    private double price;  // Added price field

    public Seat(int seatId, int row, SeatCategory seatCategory) {
        this.seatId = seatId;
        this.row = row;
        this.seatCategory = seatCategory;
        this.price = calculatePrice();  // Set price based on category
    }

    // ✅ Business Logic: Calculate price based on category
    private double calculatePrice() {
        switch(seatCategory) {
            case GOLD:
                return 500.0;
            case SILVER:
                return 300.0;
            case PLATINUM:
                return 800.0;
            default:
                return 200.0;
        }
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }
}
