package model;

import enums.SeatCategory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Show {

    int showId;
     Movie movie;
     Screen screen;
    String startTime;
    Map<Integer, SeatCategory> availableSeats = new HashMap<>();

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public Show() {

    }

    public void addSeats(List<Seat> seats){
        for(Seat seat: seats) {
            availableSeats.put(seat.getSeatId(), seat.getSeatCategory());
        }
    }

    public boolean isSeatAvailable(int seatId) {
        return availableSeats.containsKey(seatId);
    }

    public SeatCategory getSeatCategory(int seatId) {
        return availableSeats.get(seatId);
    }

    public SeatCategory bookSeat(int seatId) {
        if(isSeatAvailable(seatId)) {
            return availableSeats.remove(seatId);

        }
        return null;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
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

    public Map<Integer, SeatCategory> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Map<Integer, SeatCategory> availableSeats) {
        this.availableSeats = availableSeats;
    }

    @Override
    public String toString() {
        return "Show " + showId +
                " Screening " + movie +
                " on screen " + screen.getScreenId() +
                "\nSeats available: " + availableSeats.size();
    }
}
