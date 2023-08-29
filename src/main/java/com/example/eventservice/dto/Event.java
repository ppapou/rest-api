package com.example.eventservice.dto;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String place;
    private String speaker;
    private String eventType;
    private Date dateTime;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    //TODO: add getters/setters
}
