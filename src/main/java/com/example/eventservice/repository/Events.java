package com.example.eventservice.repository;

import com.example.eventservice.dto.Event;
import org.springframework.data.repository.CrudRepository;

public interface Events extends CrudRepository<Event, Long> {}
