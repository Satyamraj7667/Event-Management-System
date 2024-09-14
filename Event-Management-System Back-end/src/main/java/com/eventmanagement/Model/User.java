package com.eventmanagement.Model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User implements UserDetails {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String firstname;
	    private String lastname;
	    private String password;
	    private String email; 
	    private String role;
	    
	    @OneToMany(mappedBy = "createdBy")
	    private List<Event> eventsCreated;
	    
	    @OneToMany(mappedBy = "user")
	    private List<Attendee> eventsAttended;
	        
		public List<Event> getEventsCreated() {
			return eventsCreated;
		}
		public void setEventsCreated(List<Event> eventsCreated) {
			this.eventsCreated = eventsCreated;
		}
		public List<Attendee> getEventsAttended() {
			return eventsAttended;
		}
		public void setEventsAttended(List<Attendee> eventsAttended) {
			this.eventsAttended = eventsAttended;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			SimpleGrantedAuthority simpleGrantedAutority =  new SimpleGrantedAuthority(role);
			return List.of(simpleGrantedAutority);
		}
		
		
		@Override
		public String getUsername() {
			return email;
		}
		@Override
		public boolean isAccountNonExpired() {
			return true;
		}
		@Override
		public boolean isAccountNonLocked() {
			return true;
		}
		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}
		@Override
		public boolean isEnabled() {
			return true;
		}
	    

}
