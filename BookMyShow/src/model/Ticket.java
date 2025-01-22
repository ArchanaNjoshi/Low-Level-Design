package model;

import java.util.List;

public class Ticket {
    int ticketId;
    List<Integer> bookedSeats;
    int showId;
    int screenId;

    String movieName;

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
        return "Ticket{" +
                "Ticket Id=" + ticketId +
                ", My seats=" + bookedSeats +
                ", Show=" + showId +
                ", Screen=" + screenId +
                ", Movie='" + movieName + '\'' +
                '}';
    }
}
