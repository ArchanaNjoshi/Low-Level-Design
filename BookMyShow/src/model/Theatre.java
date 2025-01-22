package model;

import enums.City;

import java.util.List;

public class Theatre {

    int theatreId;
    City city;

    List<Screen> screenList;
    List<Show> showList;

    public Theatre(){}

    public Theatre(int theatreId, City city, List<Screen> screenList, List<Show> showList) {
        this.theatreId = theatreId;
        this.city = city;
        this.screenList = screenList;
        this.showList = showList;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreenList() {
        return screenList;
    }

    public void setScreenList(List<Screen> screenList) {
        this.screenList = screenList;
    }

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "theatreId=" + theatreId +
                ", city=" + city +
                ", screenList=" + screenList +
                ", showList=" + showList +
                '}';
    }
}
