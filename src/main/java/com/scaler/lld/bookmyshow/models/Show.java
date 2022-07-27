package com.scaler.lld.bookmyshow.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "shows")
public class Show extends Auditable{

    private Date startDate;
    private Date endDate;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private CinemaHall cinemaHall;

    private boolean cancelled;

    @OneToMany(mappedBy = "show")
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats = new ArrayList<>();

    public boolean isShowPending(){
        return !cancelled && endDate.after(new Date());
    }

}
