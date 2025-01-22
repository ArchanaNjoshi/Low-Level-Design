package model;

import java.util.List;

public class Show {

    int showId;
     Movie movie;

     Screen screen;

     List<Integer> availableSeatIds;

    public Show(int showId, Movie movie, Screen screen, List<Integer> availableSeatIds) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.availableSeatIds = availableSeatIds;
    }

    public Show() {

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

    public List<Integer> getAvailableSeatIds() {
        return availableSeatIds;
    }

    public void setAvailableSeatIds(List<Integer> availableSeatIds) {
        this.availableSeatIds = availableSeatIds;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", movie=" + movie +
                ", screen=" + screen +
                ", bookedSeatIds=" + availableSeatIds +
                '}';
    }
}
