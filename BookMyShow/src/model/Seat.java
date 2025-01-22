package model;

import enums.SeatCategory;

public class Seat {

    int seatId;

    int price;

    SeatCategory seatCategory;

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", price=" + price +
                ", seatCategory=" + seatCategory +
                '}';
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public Seat(int seatId, int price, SeatCategory seatCategory) {
        this.seatId = seatId;
        this.price = price;
        this.seatCategory = seatCategory;
    }


}
