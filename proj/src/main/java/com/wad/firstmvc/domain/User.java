package com.wad.firstmvc.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
