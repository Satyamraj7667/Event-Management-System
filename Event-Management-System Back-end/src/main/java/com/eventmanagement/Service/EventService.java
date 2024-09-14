package com.eventmanagement.Service;

import java.util.List;

import com.eventmanagement.Model.Event;

public interface EventService {
	
	Event getEvent(Long Id);
	void deleteEvent(Long Id);
	void saveEvent(Event e);
	List<Event> getAllEvenets();
	

}
