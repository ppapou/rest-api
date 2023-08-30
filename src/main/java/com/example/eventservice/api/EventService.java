package com.example.eventservice.api;

import com.example.eventservice.dto.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface EventService {
    default void createEvent(Event event) {}
    default void updateEvent(Event event) {}
    default Optional<Event> getEvent(Event event){return Optional.of(new Event());}
    default Iterable<Event> getAllEvents(){return new ArrayList<Event>();}
    default Iterable<Event> getAllEventsByTitle(Event event){return new ArrayList<Event>();};
    default void deleteEvent(Event event) {}
}
