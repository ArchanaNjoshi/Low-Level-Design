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
        Scanner sc = new Scanner(System.in);
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
        Boolean continueBooking = true;
        // User 1 wants to book SUZUME in banglore
//        bookMyShow.createBooking(City.BANGALORE, "SUZUME");

        while (continueBooking) {


            //TODO: Booking process
            //1. Get cities
            //2. Get MovieName
            //3. Get theatre and shows for given movie and city
            //4. Get seats for interested show
            //5. Book seats if available else throw exception
            //6. print ticket

            //1. Get cities

            System.out.println(" Select a city: ");
            City[] cities = City.values();
            for (int i = 0; i < cities.length; i++) {
                System.out.println((i + 1) + ". " + cities[i]);
            }
            System.out.print("Choose a city by entering the number: ");
            int cityChoice = sc.nextInt();

            if (cityChoice > 0 && cityChoice <= cities.length) {
                City interestedCity = cities[cityChoice - 1];

                //TODO: Set start time to shows are organise movies properly with city
                //2. Get MovieName
                System.out.println("For selected city " + interestedCity + " the available movies are: ");

                List<Movie> availableMovies = bookMyShow.movieController.getMovieByCity(interestedCity);
                for (int i = 0; i < availableMovies.size(); i++) {
                    System.out.println((i + 1) + ". " + availableMovies.get(i));
                }
                System.out.print("Choose a movie by entering the number: ");
                int movieChoice = sc.nextInt();

                if (movieChoice > 0 && movieChoice <= availableMovies.size()) {
                    Movie interestedMovie = availableMovies.get(movieChoice - 1);

                    //3. Get theatre and shows for given movie and city
                    System.out.println("For selected movie " + interestedMovie.getMovieName() + " the available shows are: ");

                    Map<Theatre, List<Show>> theatreVsShowMap = bookMyShow.getShowsForMovieAndCity(interestedCity, interestedMovie.getMovieName());
                    for (Map.Entry<Theatre, List<Show>> theatreVsShowMapEntry : theatreVsShowMap.entrySet()) {
                        Theatre theatre = theatreVsShowMapEntry.getKey();
                        List<Show> availableShows = theatreVsShowMapEntry.getValue();
                        System.out.println("Theatre " + theatre.getTheatreId());

                        for (int i = 0; i < availableShows.size(); i++) {
                            System.out.println((i + 1) + ". " + availableShows.get(i));
                        }
                        System.out.print("Choose a show by entering the number: ");
                        int showChoice = sc.nextInt();

                        if (showChoice > 0 && showChoice <= availableShows.size()) {
                            Show interestedShow = availableShows.get(showChoice - 1);


                            //4. Get seats for interested show
                            System.out.println("For selected show " + interestedShow.getShowId() + " the available seats are: ");

                            if (interestedShow.getAvailableSeatIds().size() > 0) {

                                //display seats for the selected show
                                int rowSize = 10, count = 0;
                                System.out.print("| ");
                                for (int showId : interestedShow.getAvailableSeatIds()) {

                                    System.out.print(showId + " | ");
                                    count++;
                                    if (count >= rowSize) {
                                        count = 0;
                                        System.out.println();
                                        System.out.print("| ");

                                    }
                                }
                                System.out.println("Choose a seat by entering the number: ");
                                int seatChoice = sc.nextInt();
                                //5. Book seats if available else throw exception
                                Ticket bookingTicket = bookMyShow.createBookingForShowAndSeats(interestedShow, Arrays.asList(seatChoice));
                                if (!bookingTicket.getBookedSeats().isEmpty()) {
                                    //6. print ticket
                                    System.out.println("Your ticket is " + bookingTicket.toString());
                                    System.out.println("Enjoy the show!!!");

                                } else {
                                    System.out.println("Sorry the selected seat " + seatChoice + " is not available, please try again!");
                                }

                            } else {
                                System.out.println("Sorry! No seats are available for the selected show " + interestedShow);

                            }


                        } else {
                            System.out.println("Wrong entry, please try again!");
                        }
                    }


                } else {
                    System.out.println("Wrong entry, please try again!");
                }
            } else {
                System.out.println("Wrong entry, please try again!");
                continue;
            }
            System.out.println("-------------------------------------------");
            System.out.println("Do you want to continue booking? (yes/no)");
            String option = sc.next();
            if (!(option.equalsIgnoreCase("yes") || option.equalsIgnoreCase("y"))) {
                continueBooking = false;
            }
            System.out.println("Thank you!");
        }

    }

    private void initialize() {
        createMovies();
        createTheatres();
    }

    private Map<Theatre, List<Show>> getShowsForMovieAndCity(City city, String movieName) {
        //1. Get all movies in the given city
        List<Movie> movies = movieController.getMovieByCity(city);

        //2. Check if the user interested movie is available in the city
        Movie interestedMovie = null;
        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                interestedMovie = movie;
            }
        }
        return theatreController.getAllShowsByMovie(city, interestedMovie);
    }

    private void getSeatsForShow(Show interestedShow) {
        //Given the particular show user is interested in return all available seats to choose;

        List<Integer> availableSeats = interestedShow.getAvailableSeatIds();

        if (!availableSeats.isEmpty()) {
            // Return list of seats for user to choose

        } else {
            System.out.println("Sorry! No seats are available for the selected show " + interestedShow);
            return;
        }

    }

    private Ticket createBookingForShowAndSeats(Show interestedShow, List<Integer> userInterestedSeats) {
        //TODO: Book ticket
        //4. Given the particular show user is interested in;

        List<Integer> availableSeats = interestedShow.getAvailableSeatIds();

        Ticket ticket = new Ticket();
        List<Integer> myBookedSeats = new ArrayList<>();

        if (availableSeats.contains(userInterestedSeats.get(0))) {


            //Remove seat from available seats
            availableSeats.remove(userInterestedSeats.get(0));

            //Get Seat details and add to myBookedSeats
            myBookedSeats.add(userInterestedSeats.get(0));
            Seat userSeat = interestedShow.getScreen().getSeatById(userInterestedSeats.get(0));

            ticket.setBookedSeats(myBookedSeats);
            ticket.setTicketId(1);
            ticket.setShowId(interestedShow.getShowId());
            ticket.setScreenId(interestedShow.getScreen().getScreenId());
            ticket.setMovieName(interestedShow.getMovie().getMovieName());
            ticket.setPayment(true);
            ticket.setTicketPrice(userSeat.getPrice());
            ticket.setSeatCategory(userSeat.getSeatCategory());
            return ticket;
        }


        return ticket;


    }

    private void createBooking(City city, String movieName) {
        //1. Get all movies in the given city
        List<Movie> movies = movieController.getMovieByCity(city);

        //2. Check if the user interested movie is available in the city
        Movie interestedMovie = null;
        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                interestedMovie = movie;
            }
        }
        //TODO: Book ticket

        //3. Get all theatre vs shows for the given movie and city
        Map<Theatre, List<Show>> allShowsForMovie = theatreController.getAllShowsByMovie(city, interestedMovie);

        //4. Select the particular show user is interested in
        //For simplicity, getting the first show from list rather than user selecting
        // TODO: Hardcoded for now
        Iterator<Map.Entry<Theatre, List<Show>>> iteratorOfTheatreShow = allShowsForMovie.entrySet().iterator();

        List<Show> showsForMovie = iteratorOfTheatreShow.next().getValue();
        Show interestedShow = showsForMovie.getFirst();

        List<Integer> availableSeats = interestedShow.getAvailableSeatIds();
        List<Integer> userInterestedSeats = Arrays.asList(20);

        Ticket ticket = new Ticket();
        List<Integer> myBookedSeats = new ArrayList<>();

        if (availableSeats.contains(userInterestedSeats.get(0))) {
            myBookedSeats.add(userInterestedSeats.get(0));
            ticket.setBookedSeats(myBookedSeats);
            ticket.setTicketId(1);
            ticket.setShowId(interestedShow.getShowId());
            ticket.setScreenId(interestedShow.getScreen().getScreenId());
            ticket.setMovieName(interestedShow.getMovie().getMovieName());

            System.out.println("Your ticket is " + ticket.toString());

        } else {
            System.out.println(" Sorry the selected seat " + userInterestedSeats.get(0) + " is not available");
            return;
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

        for (int seatId = 1; seatId <= 50; seatId++) {
            Seat seat = new Seat(seatId, 100, SeatCategory.REGULAR);
            seats.add(seat);
        }
        for (int seatId = 51; seatId <= 100; seatId++) {
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