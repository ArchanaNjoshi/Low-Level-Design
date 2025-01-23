package controller;

import enums.City;
import model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {

    Map<City, List<Movie>> cityMovieMap;
    List<Movie> movieList;

    public MovieController() {
        this.cityMovieMap = new HashMap<>();
        this.movieList = new ArrayList<>();
    }
    public void addMovieWithCity(Movie movie, City city) {
        movieList.add(movie);
        List<Movie> movies = cityMovieMap.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityMovieMap.put(city, movies);
    }

    public Movie getMovieByName(String movieName) {
        for(Movie movie: movieList) {
            if(movie.getMovieName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public List<Movie> getMovieByCity(City city) {
        return cityMovieMap.get(city);
    }
}
