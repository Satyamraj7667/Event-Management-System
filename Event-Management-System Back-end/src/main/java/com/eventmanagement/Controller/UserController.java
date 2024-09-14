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
import com.eventmanagement.Model.User;
import com.eventmanagement.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userserv;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> fetchUser(@PathVariable("id") Long id){
	  User u = userserv.getUser(id);	
	  return ResponseEntity.ok(u);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> fetchAllUsers(){
		List<User> l = userserv.getAllUsers();
		return ResponseEntity.ok(l);
		
	}
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody User u){
		userserv.saveUser(u);
		return ResponseEntity.ok("User created successfully");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeUser(@PathVariable("id") Long id){
		userserv.deleteUser(id);
		return ResponseEntity.ok("User deleted successfully");
	}
}
