package com.scaler.lld.bookmyshow.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="bookings")
public class Booking extends Auditable{

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Show show;

    private BookingStatus status;

    @OneToMany(mappedBy = "booking")
    private List<ShowSeat> seatsBooked = new ArrayList<>();

    public Booking(Customer customer, Show show){
        this.customer = customer;
        this.show = show;
        this.status = BookingStatus.PAYMENT_PENDING;
    }

}
