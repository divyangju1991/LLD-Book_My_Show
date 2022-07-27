package com.scaler.lld.bookmyshow.models;

import com.scaler.lld.bookmyshow.services.password.PasswordEncoder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="users")
public class User extends Auditable {

    public User(String username) {
        this.username = username;
    }

    private String username;
    private String md5Password;
    private String email;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();

    public void setPassword(String password, PasswordEncoder passwordEncoder){
        if(password.length() < 8){
            throw new RuntimeException("Password should have at least 8 characters");
        }
        String salt = "salt";
        this.md5Password = passwordEncoder.encode(password + salt);
        this.md5Password += ";" + salt;
    }

    public boolean checkPassword(String password, PasswordEncoder passwordEncoder) {
        // this method checks whether the given password
        // matches the actual password
        String salt = this.md5Password.split(";")[1];
        // password-encoder is a dependency that we need
        String encoded = passwordEncoder.encode(password + salt) + salt;
        return encoded.equals(this.getMd5Password());
    }

    public void addRole(Role role){
        this.roles.add(role);
    }
}
