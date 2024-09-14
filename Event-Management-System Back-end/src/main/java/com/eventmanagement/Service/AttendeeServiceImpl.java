package com.eventmanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.Exceptions.ResourceNotFoundException;
import com.eventmanagement.Model.Attendee;
import com.eventmanagement.Repository.AttendeeRepository;

@Service
public class AttendeeServiceImpl implements AttendeeService {
	
	@Autowired
	private AttendeeRepository atrepo;

	@Override
	public Attendee getAttendee(Long id) {
		if(atrepo.findById(id).isEmpty()==false) {
			return atrepo.findById(id).get();
		}
		else {
			throw new ResourceNotFoundException("Attendee with Id : "+id+" not found");
		}
		
	}

	@Override
	public void deleteAttendee(Long id) {
		if(atrepo.findById(id).isEmpty()==false) {
			 atrepo.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Attendee with Id : "+id+" not found");
		}
		
	}

	@Override
	public void createAttendee(Attendee a) {
		atrepo.save(a);
		
	}

	@Override
	public List<Attendee> getAllAttendees() {
		List<Attendee> l = atrepo.findAll();
		return l;
	}

	
}
