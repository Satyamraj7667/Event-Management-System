package com.eventmanagement.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eventmanagement.Configurations.JWTService;
import com.eventmanagement.Exceptions.AlreadyExistsException;
import com.eventmanagement.Exceptions.BadCredentialsException;
import com.eventmanagement.Model.Event;
import com.eventmanagement.Model.JwtRequest;
import com.eventmanagement.Model.JwtResponse;
import com.eventmanagement.Model.User;
import com.eventmanagement.Service.EventService;
import com.eventmanagement.Service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
			
		@Autowired
		private UserDetailsService userDetailsService;
		
		@Autowired
		private AuthenticationManager manager;
		
		@Autowired
		private UserService userserv;
		
		@Autowired
		private JWTService helper;
		
		@Autowired
		private EventService eventserv;
		
		
		private Logger logger = LoggerFactory.getLogger(AuthController.class);
		
		@PostMapping("/login")
		public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request){
			this.doAuthenticate(request.getEmail(), request.getPassword());
			UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
			String token = this.helper.generateToken(userDetails);
			User u = userserv.getByEmail(userDetails.getUsername()).get(0);
			String firstName = u.getFirstname();
			Long userid = u.getId();
			String role = u.getRole();
			JwtResponse response = new JwtResponse();
		    response.setJwtToken(token);
		    response.setUsername(userDetails.getUsername());
		    response.setFirstname(firstName);
			response.setUserid(userid);
            response.setRole(role);
					        
			return new ResponseEntity<JwtResponse>(response,HttpStatus.OK);
		}
		
		@PostMapping("/register")
		public ResponseEntity<String> SaveUser(@RequestBody User u){
			if(userserv.getByEmail(u.getEmail()).isEmpty() == true) {
				userserv.saveUser(u);
				return ResponseEntity.ok().body("Successfully registerd");
			}
			else {
				 throw new AlreadyExistsException();
			}
			
		}
		
		@GetMapping("/event/{id}")
		public ResponseEntity<Event> fetchEvent(@PathVariable("id") Long id){
		  Event e = eventserv.getEvent(id);	
		  return ResponseEntity.ok(e);
		}
		
		@GetMapping("/event")
		public ResponseEntity<List<Event>> fetchAllEvents(){
			List<Event> l = eventserv.getAllEvenets();
			return ResponseEntity.ok(l);
			
		}

		private void doAuthenticate(String email,String password) {
			 UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		        try {
		            manager.authenticate(authentication);
		        } 
		        catch (BadCredentialsException e) {
		            throw new BadCredentialsException(" Invalid Username or Password  !!");
		        }
		}
		
	

}
