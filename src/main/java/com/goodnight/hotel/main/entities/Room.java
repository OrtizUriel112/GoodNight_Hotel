package com.goodnight.hotel.main.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Column(name = "max_guest", nullable = false)
    private Integer max_guest;

    @ManyToOne()
    @JoinColumn(name = "room_type")
    private RoomType roomType;

    @ManyToOne()
    @JoinColumn(name = "hotel")
    private Hotel hotel;

    @OneToMany
    @JoinColumn(name = "id_room")
    private Collection<Reservation> reservationCollection;

}