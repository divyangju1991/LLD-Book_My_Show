package com.scaler.lld.bookmyshow.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "show_seats")
public class ShowSeat extends Auditable{

    @ManyToOne
    private HallSeat hallSeat;

    @ManyToOne
    private Show show;

    @ManyToOne
    private Booking booking;

    private Boolean occupied;
}
