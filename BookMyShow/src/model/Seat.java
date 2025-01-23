package model;

import enums.SeatCategory;

public class Seat {

    int seatId;

    SeatCategory seatCategory;

    public Seat() {

    }

    @Override
    public String toString() {
        return "Seat " + seatId +
                "Price: " + seatCategory.getPrice() +
                ", Seat Category=" + seatCategory;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }


    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public Seat(int seatId, SeatCategory seatCategory) {
        this.seatId = seatId;
        this.seatCategory = seatCategory;
    }


}
