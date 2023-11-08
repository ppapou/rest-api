package com.example.eventservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EventServiceImpl implements EventService<ServiceDataLayer> {

    private final EventsRepo eventsRepo;
    private final ServiceEventMapper mapper;
    public EventServiceImpl(EventsRepo eventsRepo, ServiceEventMapper mapper) {
        this.eventsRepo = eventsRepo;
        this.mapper = mapper;
    }

    @Override
    public void createEvent(ServiceDataLayer event) {

        eventsRepo.save(mapper.toRepoEvent(event));

    }

    @Override
    public ServiceDataLayer getEvent(Long id){
        return mapper.toServiceEvent(eventsRepo.findById(id));
    }

    @Override
    public void deleteEvent(ServiceDataLayer event) {
        eventsRepo.delete(mapper.toRepoEvent(event));
    }
}

