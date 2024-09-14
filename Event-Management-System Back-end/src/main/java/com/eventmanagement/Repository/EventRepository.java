package com.eventmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventmanagement.Model.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
