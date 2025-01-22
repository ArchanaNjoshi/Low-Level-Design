package model;

import java.util.List;

public class Show {

    int showId;
     Movie movie;

     Screen screen;

     List<Integer> bookedSeatIds;

    public Show(int showId, Movie movie, Screen screen, List<Integer> bookedSeatIds) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.bookedSeatIds = bookedSeatIds;
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

    public List<Integer> getBookedSeatIds() {
        return bookedSeatIds;
    }

    public void setBookedSeatIds(List<Integer> bookedSeatIds) {
        this.bookedSeatIds = bookedSeatIds;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId=" + showId +
                ", movie=" + movie +
                ", screen=" + screen +
                ", bookedSeatIds=" + bookedSeatIds +
                '}';
    }
}
