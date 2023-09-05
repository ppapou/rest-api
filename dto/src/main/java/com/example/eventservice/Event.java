package com.example.eventservice;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;


@Entity
@Getter
@Setter
@NonNull
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String place;
    private String speaker;
    private String eventType;
    @Column(name = "DATE_TIME", nullable = false, updatable = false)
    private Timestamp dateTime;

    public Event() {};
    public Event(long id, String title, String place, String speaker, String eventType) {
        this.id = id;
        this.title = title;
        this.place = place;
        this.speaker = speaker;
        this.eventType = eventType;
    }

    @PrePersist
    private void onPrePersist() {
        this.dateTime = Timestamp.valueOf(LocalDateTime.now(ZoneOffset.UTC));
    }

    public String getTitle() {return title;}
    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}

    @Override
    public String toString() {
        return String.format(
                "Event[Place='%s', Speaker='%s']", place, speaker);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Event event = (Event) o;
        return getId() != null && Objects.equals(getId(), event.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
