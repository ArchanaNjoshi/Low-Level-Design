package model;

import java.util.List;

public class Screen {

    int screenId;
    List<Seat> seats;

    public Screen(int screenId, List<Seat> seats) {
        this.screenId = screenId;
        this.seats = seats;
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

    public Seat getSeatById(int seatId) {
        for(Seat seat: seats) {
            if(seat.getSeatId()==seatId) {
                return seat;
            }
        }
        return new Seat();
    }

    @Override
    public String toString() {
        return "Screen {" +
                "screenId=" + screenId +
                ", Seating size =" + seats.size() +
                '}';
    }
}
