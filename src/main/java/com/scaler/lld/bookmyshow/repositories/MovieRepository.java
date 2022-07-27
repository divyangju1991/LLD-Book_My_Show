package com.scaler.lld.bookmyshow.repositories;

import java.util.List;

import com.scaler.lld.bookmyshow.models.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByName(String movieName);
}
