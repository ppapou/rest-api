package com.example.eventservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EventServiceImpl implements EventService<ServiceDataLayer> {

    private final EventsRepo eventsRepo;
    private final ServiceEventMapper mapper;
    private final EventMessaging messaging;

    public EventServiceImpl(EventsRepo eventsRepo, ServiceEventMapper mapper, EventMessaging messaging) {
        this.eventsRepo = eventsRepo;
        this.mapper = mapper;
        this.messaging = messaging;
    }

    @Override
    public void createEvent(ServiceDataLayer event) {
        messaging.createEvent(event);
        eventsRepo.save(mapper.toRepoEvent(event));
    }

    @Override
    public ServiceDataLayer getEvent(Long id){
        return mapper.toServiceEvent(eventsRepo.findById(id));
    }

    @Override
    public void deleteEvent(ServiceDataLayer event) {
        messaging.deleteEvent(event.getId());
        eventsRepo.delete(mapper.toRepoEvent(event));
    }
}

