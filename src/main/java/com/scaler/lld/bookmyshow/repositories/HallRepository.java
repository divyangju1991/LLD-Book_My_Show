package com.scaler.lld.bookmyshow.repositories;

import com.scaler.lld.bookmyshow.models.CinemaHall;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<CinemaHall, Long> {
}
