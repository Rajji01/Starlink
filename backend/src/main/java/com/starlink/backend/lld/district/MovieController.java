package com.starlink.backend.lld.district;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieController {
    List<Movie> allMovies;
    Map<String,List<Movie>> cityMovie;

    // ✅ Business Logic: Get movies by city
    public List<Movie> getMoviesByCity(String city) {
        return cityMovie.getOrDefault(city, List.of());
    }

    // ✅ Business Logic: Add movie to city
    public void addMovieToCity(String city, Movie movie) {
        if (!allMovies.contains(movie)) {
            allMovies.add(movie);
        }

        cityMovie.computeIfAbsent(city, k -> new java.util.ArrayList<>()).add(movie);
    }

    // ✅ Business Logic: Search movie by name
    public List<Movie> searchMovie(String movieName) {
        return allMovies.stream()
                .filter(m -> m.getMovieName().toLowerCase().contains(movieName.toLowerCase()))
                .collect(Collectors.toList());
    }
}
