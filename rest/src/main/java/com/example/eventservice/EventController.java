package com.example.eventservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO: - Is it required to return the http status?
 *       - How is better to handle the exceptions?
 */


@RestController
public class EventController {

    private final EventServiceImpl eventService;

    EventController(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/events")
    public void createEvent(@RequestBody ServiceDataLayer event) {
        eventService.createEvent(event);
    }

    @GetMapping("/events/{id}")
    public ServiceDataLayer getEvent(@PathVariable Long id) {
        return eventService.getEvent(id);
    }

    @DeleteMapping("/events")
    public void delete(@RequestBody ServiceDataLayer event) {
        eventService.deleteEvent(event);
    }
}
