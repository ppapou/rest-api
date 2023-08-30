package com.example.eventservice.repository;

import com.example.eventservice.dto.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface Events extends CrudRepository<Event, Long> {
    default void update(Event event) {}
    default Optional<Event> getEvent(Event event) {
        return findById(event.getId());
    }

    @Query("select e from Event e where e.title like :title")
    Iterable<Event> getAllByTitle(@Param("title") String title);
}
