package com.example.eventservice;


public interface EventService<T> {
    <S extends T> void createEvent(S event);

    T getEvent(Long id);

    void deleteEvent(T event);

}
