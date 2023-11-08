package com.example.eventservice;

import java.util.Optional;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-04T12:51:24-0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.2.1.jar, environment: Java 17.0.8.1 (Amazon.com Inc.)"
)
@Component
public class ServiceEventMapperImpl implements ServiceEventMapper {

    @Override
    public ServiceDataLayer toServiceEvent(Optional<Event> event) {
        if ( event == null ) {
            return null;
        }

        ServiceDataLayer.ServiceDataLayerBuilder serviceDataLayer = ServiceDataLayer.builder();

        return serviceDataLayer.build();
    }

    @Override
    public Event toRepoEvent(ServiceDataLayer event) {
        if ( event == null ) {
            return null;
        }

        Event event1 = new Event();

        event1.setId( event.getId() );
        event1.setTitle( event.getTitle() );
        event1.setPlace( event.getPlace() );
        event1.setSpeaker( event.getSpeaker() );
        event1.setEventType( event.getEventType() );
        event1.setDateTime( event.getDateTime() );

        return event1;
    }
}
