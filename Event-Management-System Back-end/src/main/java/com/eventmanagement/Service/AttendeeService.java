package com.eventmanagement.Service;

import java.util.List;

import com.eventmanagement.Model.Attendee;

public interface AttendeeService {

	Attendee getAttendee(Long id);
	void deleteAttendee(Long id);
	void createAttendee(Attendee a);
	List<Attendee> getAllAttendees();
}
