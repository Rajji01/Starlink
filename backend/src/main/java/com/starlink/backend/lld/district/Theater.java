package com.starlink.backend.lld.district;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Theater {
    private int theaterId;
    private String address;
    private String city;
    private List<Screen> screens;
    private List<Show> shows;

    public Theater(int theaterId, String address, String city) {
        this.theaterId = theaterId;
        this.address = address;
        this.city = city;
        this.screens = new ArrayList<>();
        this.shows = new ArrayList<>();
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
    // ✅ Business Logic: Get shows by movie
    public List<Show> getShowsByMovie(int movieId) {
        return shows.stream()
                .filter(show -> show.getMovie().getMovieId() == movieId)
                .collect(Collectors.toList());
    }

    // ✅ Business Logic: Add show
    public void addShow(Show show) {
        shows.add(show);
    }

    // ✅ Business Logic: Add screen
    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    // ✅ Business Logic: Get screen by ID
    public Screen getScreen(int screenId) {
        return screens.stream()
                .filter(s -> s.getScreenId() == screenId)
                .findFirst()
                .orElse(null);
    }
}
