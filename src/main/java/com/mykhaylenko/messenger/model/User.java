package com.mykhaylenko.messenger.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by pavlo.mykhaylenko on 8/14/2015.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3, max = 20)
    @Column(nullable = false, unique = true)
    private String username;

    @NotNull
    //    @Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+\n"
    //            + "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{email.invalid}")
    @Email //can be used instead of pattern annotation
    @Column(nullable = false)
    private String email;

    @NotNull
    @Size(min = 4)
    @Column(nullable = false)
    private String password;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
