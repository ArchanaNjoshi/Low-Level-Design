import controller.MovieController;
import controller.TheatreController;
import enums.City;
import enums.SeatCategory;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;
    BookMyShow() {
        this.theatreController = new TheatreController();
        this.movieController = new MovieController();
    }
    public static void main(String[] args) {


    }

    private void createTheatres() {
        List<Theatre> theatres = new ArrayList<>();

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(1);
        pvrTheatre.setCity(City.BANGALORE);
        pvrTheatre.setScreenList(createScreens(1));

        List<Show> shows = new ArrayList<>();
        shows.add(createShow(1, pvrTheatre.getScreenList().get(2), movieController.getMovieByName("INCEPTION")));
        shows.add(createShow(2, pvrTheatre.getScreenList().get(2), movieController.getMovieByName("SUZUME")));

        pvrTheatre.setShowList(shows);

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(2);
        inoxTheatre.setCity(City.DELHI);
        inoxTheatre.setScreenList(createScreens(2));
        List<Show> shows2 = new ArrayList<>();
        shows2.add(createShow(1, inoxTheatre.getScreenList().get(2), movieController.getMovieByName("INCEPTION")));
        shows2.add(createShow(2, inoxTheatre.getScreenList().get(2), movieController.getMovieByName("SUZUME")));

        inoxTheatre.setShowList(shows2);

        theatreController.addTheatreWithCity(pvrTheatre, City.BANGALORE);
        theatreController.addTheatreWithCity(inoxTheatre, City.DELHI);
    }

    private Show createShow(int id, Screen screen, Movie movie) {
        Show newShow = new Show();
        newShow.setShowId(id);
        newShow.setScreen(screen);
        newShow.setMovie(movie);
        return newShow;
    }
    private List<Screen> createScreens(int screenId) {
        List<Screen> screens = new ArrayList<>();

        Screen screen = new Screen(screenId, createSeats());
        screens.add(screen);
        return screens;
    }
    private List<Seat> createSeats() {
        List<Seat> seats = new ArrayList<>();

        for(int seatId = 1; seatId <= 50 ; seatId ++) {
            Seat seat = new Seat(seatId, 100, SeatCategory.REGULAR);
            seats.add(seat);
        }
        for(int seatId = 51; seatId <= 100 ; seatId ++) {
            Seat seat = new Seat(seatId, 200, SeatCategory.PREMIUM);
            seats.add(seat);
        }
        return seats;
    }
    private void createMovies() {
        Movie movie1 = new Movie(1, "INCEPTION", 180);
        Movie movie2 = new Movie(2, "SUZUME", 120);

        movieController.addMovieWithCity(movie1, City.BANGALORE);
        movieController.addMovieWithCity(movie1, City.DELHI);
        movieController.addMovieWithCity(movie2, City.BANGALORE);
        movieController.addMovieWithCity(movie2, City.DELHI);


    }
}