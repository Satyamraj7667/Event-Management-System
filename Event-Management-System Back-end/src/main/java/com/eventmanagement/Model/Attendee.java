package com.eventmanagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendee {
	
	    @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String name;
	    private String email;
	    private boolean rsvp;

	    @ManyToOne
	    @JoinColumn(name = "event_id")
	    private Event event;
	    
	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    private User user; // Attendees can also be users of the systems

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public boolean isRsvp() {
			return rsvp;
		}

		public void setRsvp(boolean rsvp) {
			this.rsvp = rsvp;
		}

		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}
	    
	    
	    

}
