package controller;

import enums.City;
import model.Movie;
import model.Show;
import model.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityTheatreMap;
    List<Theatre> theatreList;

    public TheatreController() {
        this.cityTheatreMap = new HashMap<>();
        this.theatreList = new ArrayList<>();
    }

    public void addTheatreWithCity(Theatre theatre, City city) {
        theatreList.add(theatre);
        List<Theatre> theatres = cityTheatreMap.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityTheatreMap.put(city, theatres);
    }

    // All shows for the given movie in a city with theatre
    public Map<Theatre, List<Show>> getAllShowsByMovie(City city, Movie movie) {
        Map<Theatre, List<Show>> showsForMovieTheatre = new HashMap<>();
        List<Theatre> theatresInCity = cityTheatreMap.get(city);

        for(Theatre theatre: theatresInCity) {
            List<Show> showsForMovie = new ArrayList<>();
            List<Show> showsInTheatre = theatre.getShowList();

            for(Show show: showsInTheatre) {
                if(show.getMovie().getMovieId() == movie.getMovieId()) {
                    showsForMovie.add(show);
                }
            }

            if(!showsForMovie.isEmpty()) {
                showsForMovieTheatre.put(theatre, showsForMovie);
            }
        }
        return showsForMovieTheatre;
    }
    @Override
    public String toString() {
        return "TheatreController{" +
                "cityTheatreMap=" + cityTheatreMap +
                ", theatreList=" + theatreList +
                '}';
    }
}
