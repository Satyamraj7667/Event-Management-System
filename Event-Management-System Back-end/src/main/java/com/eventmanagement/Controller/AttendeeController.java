package com.eventmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.Model.Attendee;
import com.eventmanagement.Model.Event;
import com.eventmanagement.Service.AttendeeService;

@RestController
@RequestMapping("/attendee")
public class AttendeeController {
	
	@Autowired
	private AttendeeService atservice;
	
	@GetMapping("/{id}")
	public ResponseEntity<Attendee> fetchEvent(@PathVariable("id") Long id){
	  Attendee e = atservice.getAttendee(id);	
	  return ResponseEntity.ok(e);
	}
	
	@GetMapping
	public ResponseEntity<List<Attendee>> fetchAllAttendees(){
		List<Attendee> l = atservice.getAllAttendees();
		return ResponseEntity.ok(l);
		
	}
	
	@PostMapping
	public ResponseEntity<String> createAttendee(@RequestBody Attendee a){
		atservice.createAttendee(a);
		return ResponseEntity.ok("Attendee created successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeAttendee(@PathVariable("id") Long id){
		atservice.deleteAttendee(id);
		return ResponseEntity.ok("Attendee deleted successfully");
	}

}
