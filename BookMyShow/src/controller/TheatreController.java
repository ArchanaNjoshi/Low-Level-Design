package controller;

import enums.City;
import model.Movie;
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

    @Override
    public String toString() {
        return "TheatreController{" +
                "cityTheatreMap=" + cityTheatreMap +
                ", theatreList=" + theatreList +
                '}';
    }
}
