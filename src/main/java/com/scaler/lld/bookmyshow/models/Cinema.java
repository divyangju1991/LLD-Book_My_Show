package com.scaler.lld.bookmyshow.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "cinemas")
public class Cinema extends Auditable {

    private String name;
    private String address;

    @OneToMany(mappedBy = "cinema")
    private List<CinemaHall> halls = new ArrayList<>();
}
