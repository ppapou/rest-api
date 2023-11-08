package com.example.eventservice;


public interface EventMessaging <S> {
    void createEvent(S event);

    void deleteEvent(S event);
}

