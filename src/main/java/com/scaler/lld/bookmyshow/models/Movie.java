package com.scaler.lld.bookmyshow.models;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@Entity
@Table(name="movies")
public class Movie extends Auditable {

    private String name;
    private Integer durationInMinutes;
    private AtomicInteger likes = new AtomicInteger(0);

    @OneToMany(mappedBy = "movie")
    private List<Show> shows = new ArrayList<>();

    public Integer upVote(){
        return this.likes.incrementAndGet();
    }

}