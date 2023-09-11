package com.example.eventservice;

import com.example.eventservice.config.ServiceMapperConfig;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper(config = ServiceMapperConfig.class)
@Component
public interface ServiceEventMapper {

    ServiceDataLayer toServiceEvent(Optional<Event> event);
    Event toRepoEvent(ServiceDataLayer event);

}
