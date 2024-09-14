package com.eventmanagement.Service;

import java.util.List;

import com.eventmanagement.Model.User;

public interface UserService {
	
	User getUser(Long Id);
	void deleteUser(Long Id);
	void saveUser(User u);
	List<User> getAllUsers();
	public List<User> getByEmail(String email);
		

}
