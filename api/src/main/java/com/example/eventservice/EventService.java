package com.example.eventservice;

import java.util.Optional;
import java.util.ArrayList;

public interface EventService {
    default Event createEvent(Event event) {return event;}
    default void updateEvent(Event event) {}
    default Optional<Event> getEvent(Long id){return Optional.of(new Event());}
    default Iterable<Event> getAllEvents(){return new ArrayList<Event>();}
    default Iterable<Event> getAllEventsByTitle(Event event){return new ArrayList<Event>();};
    default void deleteEvent(Event event) {}
}
