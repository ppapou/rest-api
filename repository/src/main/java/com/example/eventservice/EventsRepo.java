package com.example.eventservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventsRepo extends CrudRepository<Event, Long> {}
