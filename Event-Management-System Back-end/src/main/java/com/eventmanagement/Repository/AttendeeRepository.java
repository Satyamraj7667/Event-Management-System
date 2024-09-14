package com.eventmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventmanagement.Model.Attendee;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {

}
