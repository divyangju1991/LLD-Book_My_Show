package com.scaler.lld.bookmyshow.services;

import java.util.List;

import com.scaler.lld.bookmyshow.models.Movie;

import com.scaler.lld.bookmyshow.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> listMovies() {
        return movieRepository.findAll();
    }

    public List<Movie> searchMovies(String movieName) {
        return movieRepository.findByName(movieName);
    }

}
