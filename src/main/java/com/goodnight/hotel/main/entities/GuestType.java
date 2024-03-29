package com.goodnight.hotel.main.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "guest_type")
public class GuestType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @OneToMany
    @JoinColumn(name = "id_guest_type")
    private Collection<Guest> guestCollection;
    public GuestType(){}
}