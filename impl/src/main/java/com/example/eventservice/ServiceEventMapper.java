package com.example.eventservice;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper
@Component
public interface ServiceEventMapper {

    ServiceDataLayer toServiceEvent(Optional<Event> event);
    Event toRepoEvent(ServiceDataLayer event);

}
