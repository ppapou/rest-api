package com.example.eventservice.impl;

import com.example.eventservice.api.EventService;
import com.example.eventservice.dto.Event;
import com.example.eventservice.repository.Events;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

public class EventServiceImpl implements EventService {

    private final Events events;

    @Autowired
    EventServiceImpl(Events events) {
        this.events = events;
    }

    @Override
    public void createEvent(Event event) {
        events.save(event);
    }
    //TODO: discuss, which field should be updated
    public void updateEvent(Event event) {
        events.update(event);
    }

    @Override
    public Optional<Event> getEvent(Event event){
        return events.getEvent(event);
    }

    @Override
    public Iterable<Event> getAllEvents(){
        return events.findAll();
    }

    @Override
    public Iterable<Event> getAllEventsByTitle(Event event){
        return events.getAllByTitle(event.getTitle());
    }

    @Override
    public void deleteEvent(Event event) {
        events.delete(event);
    }
}
