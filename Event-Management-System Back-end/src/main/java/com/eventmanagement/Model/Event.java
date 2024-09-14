package com.eventmanagement.Model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Event {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String name;
	    private String description;
	    private LocalDateTime date;
	    private String location;
	    
	    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
	    private List<Attendee> attendees;
	    
	    @ManyToOne
	    @JoinColumn(name = "created_by")
	    private User createdBy;
	    
	    
		public User getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(User createdBy) {
			this.createdBy = createdBy;
		}
		public List<Attendee> getAttendees() {
			return attendees;
		}
		public void setAttendees(List<Attendee> attendees) {
			this.attendees = attendees;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public LocalDateTime getDate() {
			return date;
		}
		public void setDate(LocalDateTime date) {
			this.date = date;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
	
	    
	

}
