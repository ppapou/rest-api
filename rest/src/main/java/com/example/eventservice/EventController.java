package com.example.eventservice;

import org.springframework.web.bind.annotation.*;
import java.util.Optional;
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
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping("/events/{id}")
    public Optional<Event> one(@PathVariable Long id) {
        return eventService.getEvent(id);
    }

}
