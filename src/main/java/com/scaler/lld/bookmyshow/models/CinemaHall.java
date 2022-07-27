package com.scaler.lld.bookmyshow.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cinemaHalls")
public class CinemaHall extends Auditable{

    private Integer hallNumber;
    private Integer seatCount;

    @ManyToOne
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaHall")
    private List<HallSeat> hallSeats = new ArrayList<>();

    @OneToMany(mappedBy = "cinemaHall")
    private List<Show> shows = new ArrayList<>();
}
