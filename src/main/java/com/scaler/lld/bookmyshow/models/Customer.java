package com.scaler.lld.bookmyshow.models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "customers")
@Builder
public class Customer extends Auditable {

    private String fullName;
    private String phone;
    private String city;
    private String email;

    @OneToMany(mappedBy = "customer")
    @Builder.Default
    private List<Booking> bookings = new ArrayList<>();

    @OneToOne
    private User user;

}
