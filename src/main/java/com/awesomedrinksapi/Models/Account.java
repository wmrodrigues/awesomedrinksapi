package com.awesomedrinksapi.Models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Account {
    private @Id @GeneratedValue Long id;
    private String name;
    private String email;
    private String firstName;
    private String lastName;
    private boolean confirmed;

    public Account(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
