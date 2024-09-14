package com.eventmanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.Exceptions.ResourceNotFoundException;
import com.eventmanagement.Model.Event;
import com.eventmanagement.Repository.EventRepository;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventRepository eventrepo;

	@Override
	public Event getEvent(Long Id) {
		if(eventrepo.findById(Id).isEmpty()==false) {
			return eventrepo.findById(Id).get();
		}
		else {
			throw new ResourceNotFoundException("Event with Id : "+Id+" not found");
		}
		
	}

	@Override
	public void deleteEvent(Long Id) {
		if(eventrepo.findById(Id).isEmpty()==false) {
			 eventrepo.deleteById(Id);
		}
		else {
			throw new ResourceNotFoundException("Event with Id : "+Id+" not found");
		}
		
	}

	@Override
	public void saveEvent(Event e) {
		eventrepo.save(e);
	}

	@Override
	public List<Event> getAllEvenets() {
		List<Event> l = eventrepo.findAll();
		return l;
	}

}
