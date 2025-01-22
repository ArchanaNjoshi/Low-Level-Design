package model;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    Show show;
    List<Seat> seats = new ArrayList<>();

    Boolean payment;

    public Booking(Show show, List<Seat> seats, Boolean payment) {
        this.show = show;
        this.seats = seats;
        this.payment = payment;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "show=" + show +
                ", seats=" + seats +
                ", payment=" + payment +
                '}';
    }
}
