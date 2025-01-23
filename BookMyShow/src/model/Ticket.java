package model;

import enums.SeatCategory;

import java.util.List;

public class Ticket {
    int ticketId;
    List<Integer> bookedSeats;
    int showId;
    int screenId;

    String movieName;

    int ticketPrice;

    SeatCategory seatCategory;

    Boolean payment;

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory = seatCategory;
    }

    public Boolean getPayment() {
        return payment;
    }

    public void setPayment(Boolean payment) {
        this.payment = payment;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public List<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Integer> bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "\n*****Ticket " + ticketId + "*****" +
                "\nMovie: " + movieName +
                "\nShow Id: " + showId +
                "\nScreen Id: " + screenId +
                "\nSeat number: " + bookedSeats.toString() +
                "\nSeat type: " + seatCategory +
                "\nAmount: " + ((float) ticketPrice) +
                "\nPayment " +( payment ? "successful :)" : "failed:(" );
    }
}
