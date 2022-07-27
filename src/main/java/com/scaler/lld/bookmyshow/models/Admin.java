package com.scaler.lld.bookmyshow.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "admins")
public class Admin extends Auditable {

    private String designation;
    private String phone1;
    private String phone2;
    private String email;
    private Long numberOfYearsInTheCompany;

    @OneToOne
    private User user;
}
