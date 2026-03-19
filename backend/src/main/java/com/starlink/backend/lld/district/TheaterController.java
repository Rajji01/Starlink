package com.starlink.backend.lld.district;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TheaterController {
    Map<String, List<Theater>> cityTheater;
    List<Theater> allTheaters;

    public TheaterController(Map<String, List<Theater>> cityTheater, List<Theater> allTheaters) {
        this.cityTheater = cityTheater;
        this.allTheaters = allTheaters;
    }

    public Map<String, List<Theater>> getCityTheater() {
        return cityTheater;
    }

    public void setCityTheater(Map<String, List<Theater>> cityTheater) {
        this.cityTheater = cityTheater;
    }

    public List<Theater> getAllTheaters() {
        return allTheaters;
    }

    public void setAllTheaters(List<Theater> allTheaters) {
        this.allTheaters = allTheaters;
    }
    // ✅ Business Logic: Get theaters by city
    public List<Theater> getTheatersByCity(String city) {
        return cityTheater.getOrDefault(city, List.of());
    }

    // ✅ Business Logic: Get shows by movie and city
    public List<Show> getShowsByMovieAndCity(String city, int movieId) {
        return getTheatersByCity(city).stream()
                .flatMap(theater -> theater.getShows().stream())
                .filter(show -> show.getMovie().getMovieId() == movieId)
                .collect(Collectors.toList());
    }

    // ✅ Business Logic: Add theater
    public void addTheater(Theater theater) {
        allTheaters.add(theater);
        cityTheater.computeIfAbsent(theater.getCity(), k -> new java.util.ArrayList<>()).add(theater);
    }
}
