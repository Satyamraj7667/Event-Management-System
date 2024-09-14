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

import com.eventmanagement.Model.Event;
import com.eventmanagement.Service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventserv;
	
	@GetMapping("/{id}")
	public ResponseEntity<Event> fetchEvent(@PathVariable("id") Long id){
	  Event e = eventserv.getEvent(id);	
	  return ResponseEntity.ok(e);
	}
	
	@GetMapping
	public ResponseEntity<List<Event>> fetchAllEvents(){
		List<Event> l = eventserv.getAllEvenets();
		return ResponseEntity.ok(l);
		
	}
	
	@PostMapping
	public ResponseEntity<String> createEvent(@RequestBody Event e){
		eventserv.saveEvent(e);
		return ResponseEntity.ok("Event created successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeEvent(@PathVariable("id") Long id){
		eventserv.deleteEvent(id);
		return ResponseEntity.ok("Event deleted successfully");
	}
}
