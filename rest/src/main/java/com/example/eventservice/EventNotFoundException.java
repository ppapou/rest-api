package com.example.eventservice;

public class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("Could not find Event  " + id);
    }
}
