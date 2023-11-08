package com.example.eventservice.kafka;

import com.example.eventservice.Event;
import com.example.eventservice.EventServiceImpl;
import com.example.eventservice.ServiceDataLayer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.List;


@Component
public class EventConsumer {

    private final EventServiceImpl eventService;

    public EventConsumer(EventServiceImpl eventService) {
        this.eventService = eventService;
    }

    @KafkaListener(topics = "${topic.name.create-event-request}", groupId="${spring.kafka.consumer.group-id}")
    public void createEvent(ServiceDataLayer event) {
        eventService.createEvent(event);
    }

    @KafkaListener(topics = "${topic.name.delete-event-request}", groupId="${spring.kafka.consumer.group-id}")
    public void deleteEvent(ServiceDataLayer event){
        eventService.deleteEvent(event);
    }
}
