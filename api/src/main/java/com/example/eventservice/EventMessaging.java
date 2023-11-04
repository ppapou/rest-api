package com.example.eventservice;

public interface EventMessaging <S> {
    void createEvent(S event);
    void updateEvent(S event);
    void deleteEvent(Long id);
}

