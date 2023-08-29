package com.example.eventservice.api;

import com.example.eventservice.dto.Event;

import java.util.ArrayList;
import java.util.List;


public interface EventService {
    default void createEvent() {}
    default void updateEvent() {}
    default Event getEvent(){return new Event();}
    default List<Event> getAllEvents(){return new ArrayList<Event>();}
    default List<Event> getAllEventsByTitle(String title){return new ArrayList<Event>();};
}
