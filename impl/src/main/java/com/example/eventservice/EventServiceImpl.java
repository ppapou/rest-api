package com.example.eventservice;


import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EventServiceImpl implements EventService {

    Logger logger = Logger.getLogger(EventServiceImpl.class.getName());

    private Events events;

    public EventServiceImpl(Events events) {
        this.events = events;
    }

    public Event createEvent(Event event) {
        logger.info("Creating the event with ID -> " + event.getId());
        events.save(event);
        return event;
    }

    public void updateEvent(Event event) {
        events.update(event);
    }

    @Override
    public Optional<Event> getEvent(Long id){
        return events.getEvent(id);
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
