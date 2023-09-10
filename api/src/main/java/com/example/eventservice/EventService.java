package com.example.eventservice;


import java.util.Optional;

public interface EventService<T> {
    <S extends T> void createEvent(S event);

    T getEvent(Long id);

    void deleteEvent(T event);

}
