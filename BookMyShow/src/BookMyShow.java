import controller.MovieController;
import controller.TheatreController;
import enums.City;
import enums.SeatCategory;
import model.*;

import java.util.*;
import java.util.stream.Collectors;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;
    BookMyShow() {
        this.theatreController = new TheatreController();
        this.movieController = new MovieController();
    }
    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();

        // User 1 wants to book SUZUME in banglore
        bookMyShow.createBooking(City.BANGALORE, "SUZUME");



    }

    private void initialize() {
        createMovies();
        createTheatres();
    }

    private void createBooking(City city, String movieName) {
        //1. Get all movies in the given city
        List<Movie> movies = movieController.getMovieByCity(city);

        //2. Check if the user interested movie is available in the city
        Movie interestedMovie = null;
        for(Movie movie: movies) {
            if(movie.getMovieName().equals(movieName)) {
                interestedMovie = movie;
            }
        }
        //TODO: Book ticket

        //3. Get all theatre vs shows for the given movie and city
        Map<Theatre, List<Show>> allShowsForMovie = theatreController.getAllShowsByMovie(city, interestedMovie);

        //4. Select the particular show user is interested in
        Iterator<Map.Entry<Theatre, List<Show>>> iteratorOfTheatreShow = allShowsForMovie.entrySet().iterator();
        //For simplicity, getting the first show from list rather than user selecting
        // TODO: Hardcoded for now

        List<Show> showsForMovie = iteratorOfTheatreShow.next().getValue();
        Show interestedShow = showsForMovie.getFirst();

        List<Integer> availableSeats = interestedShow.getAvailableSeatIds();
        List<Integer> userInterestedSeats = Arrays.asList(20);

        Ticket ticket = new Ticket();
        List<Integer> myBookedSeats = new ArrayList<>();

            if(availableSeats.contains(userInterestedSeats.get(0))) {
              myBookedSeats.add(userInterestedSeats.get(0));
              ticket.setBookedSeats(myBookedSeats);
              ticket.setTicketId(1);
              ticket.setShowId(interestedShow.getShowId());
              ticket.setScreenId(interestedShow.getScreen().getScreenId());
              ticket.setMovieName(interestedShow.getMovie().getMovieName());

              System.out.println("Your ticket is "+ticket.toString());

            } else {
                System.out.println(" Sorry the selected seat "+ userInterestedSeats.get(0)+" is not available");
                return ;
            }

    }
    private void createTheatres() {
        List<Theatre> theatres = new ArrayList<>();

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setTheatreId(1);
        pvrTheatre.setCity(City.BANGALORE);
        pvrTheatre.setScreenList(createScreens(1));

        List<Show> shows = new ArrayList<>();
        shows.add(createShow(1, pvrTheatre.getScreenList().get(0), movieController.getMovieByName("INCEPTION")));
        shows.add(createShow(2, pvrTheatre.getScreenList().get(0), movieController.getMovieByName("SUZUME")));

        pvrTheatre.setShowList(shows);

        Theatre inoxTheatre = new Theatre();
        inoxTheatre.setTheatreId(2);
        inoxTheatre.setCity(City.DELHI);
        inoxTheatre.setScreenList(createScreens(2));
        List<Show> shows2 = new ArrayList<>();
        shows2.add(createShow(1, inoxTheatre.getScreenList().get(0), movieController.getMovieByName("INCEPTION")));
        shows2.add(createShow(2, inoxTheatre.getScreenList().get(0), movieController.getMovieByName("SUZUME")));

        inoxTheatre.setShowList(shows2);

        theatreController.addTheatreWithCity(pvrTheatre, City.BANGALORE);
        theatreController.addTheatreWithCity(inoxTheatre, City.DELHI);
    }

    private Show createShow(int id, Screen screen, Movie movie) {
        Show newShow = new Show();
        newShow.setShowId(id);
        newShow.setScreen(screen);
        newShow.setMovie(movie);
        newShow.setAvailableSeatIds(screen.getSeats().stream().map(Seat::getSeatId).collect(Collectors.toList()));
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