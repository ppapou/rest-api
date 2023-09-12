package com.example.eventservice;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.sql.Timestamp;

@Value
@Builder
@EqualsAndHashCode
public class ServiceDataLayer {
    @EqualsAndHashCode.Include
    Long id;
    String title;
    String place;
    String speaker;
    String eventType;
    Timestamp dateTime;
}
