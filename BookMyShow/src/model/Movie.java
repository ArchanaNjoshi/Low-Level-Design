package model;

public class Movie {
    int movieId;
    String movieName;

    int duration;

    public Movie() {}

    public Movie(int movieId, String movieName, int duration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }


    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", duration=" + duration +
                '}';
    }


}
