package com.example.eventservice.kafka;

import com.example.eventservice.EventMessaging;
import com.example.eventservice.ServiceDataLayer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import java.util.concurrent.CompletableFuture;


@Slf4j
@Component
public class EventProducer implements EventMessaging<ServiceDataLayer>{

    @Value("${topic.name.create-event-request}")
    String createEventReq;
    @Value("${topic.name.delete-event-request}")
    String deleteEventReq;

    private final KafkaTemplate<String, ServiceDataLayer> kafkaTemplate;
    public EventProducer(KafkaTemplate<String, ServiceDataLayer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void createEvent(ServiceDataLayer event) {
        CompletableFuture<SendResult<String, ServiceDataLayer>> future = kafkaTemplate.send(createEventReq, event);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent event=[ CREATE ] with offset=[" + result.getRecordMetadata()
                        .offset() + "]");
            } else {
                System.out.println("Unable to send event=[ CREATE ] due to : " + ex.getMessage());
            }
        });
    }

    @Override
    public void deleteEvent(ServiceDataLayer event) {
        kafkaTemplate.send(createEventReq, event);
    }

}
