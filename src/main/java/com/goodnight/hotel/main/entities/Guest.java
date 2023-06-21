package com.goodnight.hotel.main.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "guest")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_guest", nullable = false)
    private Integer id;

    @Column(name = "first_name", length=50, nullable = false)
    private String first_name;

    @Column(name = "last_name", length=50, nullable = false)
    private String last_name;

    @Column(name = "email", length=50, nullable = false)
    private String email;


}