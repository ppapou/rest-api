package com.example.eventservice;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Events extends CrudRepository<Event, Long> {
    default void update(Event event) {}
    default Optional<Event> getEvent(Long id) {
        return findById(id);
    }

    @Query("select e from Event e where e.title like :title")
    Iterable<Event> getAllByTitle(@Param("title") String title);

    Event save(Event event);
}
