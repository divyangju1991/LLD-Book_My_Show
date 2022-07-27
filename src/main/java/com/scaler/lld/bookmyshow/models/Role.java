package com.scaler.lld.bookmyshow.models;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="roles")
public class Role extends Auditable {

    private String name;
    private String description;
}
