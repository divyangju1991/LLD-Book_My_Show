package com.scaler.lld.bookmyshow.controllers;

import com.scaler.lld.bookmyshow.models.Movie;
import com.scaler.lld.bookmyshow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> requestMethodName() {
        return movieService.listMovies();
    }

    @RequestMapping(value = "/movie/{movieName}", method = RequestMethod.GET, produces = "application/json")
    public List<Movie> requestMethodName(@PathVariable(value = "movieName", required = true) String movieName) {
        return movieService.searchMovies(movieName);
    }
}
