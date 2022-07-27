package com.scaler.lld.bookmyshow.repositories;

import com.scaler.lld.bookmyshow.models.Cinema;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
