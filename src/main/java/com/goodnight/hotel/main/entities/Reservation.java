package com.goodnight.hotel.main.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "start_date", nullable = false)
    private Date start_date;

    @Column(name = "end_date", nullable = false)
    private Date end_date;

    @Column(name = "check_in", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean check_in;

    @Column(name = "check_out", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean check_out;

    @ManyToOne()
    @JoinColumn(name = "guest")
    private Guest guest;

    @ManyToOne
    @JoinColumn(name = "room")
    private Room room;

}