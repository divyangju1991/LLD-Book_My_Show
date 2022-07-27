package com.scaler.lld.bookmyshow.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "hall_seats")
public class HallSeat extends Auditable {

    private String seatLocation;
    private String seatType;
    private boolean underMaintenance;

    @ManyToOne
    private CinemaHall cinemaHall;

    @OneToMany(mappedBy = "hallSeat")
    private List<ShowSeat> showSeats = new ArrayList<>();
}
