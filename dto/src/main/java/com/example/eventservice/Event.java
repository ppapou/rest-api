package com.example.eventservice;

import jakarta.persistence.*;
import lombok.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;


@Entity
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String place;
    private String speaker;
    private String eventType;
    @Column(name = "DATE_TIME", nullable = false, updatable = false)
    private Timestamp dateTime;

    @PrePersist
    private void onPrePersist() {
        this.dateTime = Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC));
    }

    @Override
    public String toString() {
        return String.format(
                "Event[Place='%s', Speaker='%s']", place, speaker);
    }
}
