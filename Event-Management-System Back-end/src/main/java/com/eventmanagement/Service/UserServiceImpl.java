package com.eventmanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventmanagement.Exceptions.ResourceNotFoundException;
import com.eventmanagement.Model.User;
import com.eventmanagement.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userrepo;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;

	@Override
	public User getUser(Long Id) {
		if(userrepo.findById(Id).isEmpty()==false) {
			return userrepo.findById(Id).get();
		}
		else {
			throw new ResourceNotFoundException("User with Id : "+Id+" not found");
		}
	}

	@Override
	public void deleteUser(Long Id) {
		if(userrepo.findById(Id).isEmpty()==false) {
			 userrepo.deleteById(Id);
		}
		else {
			throw new ResourceNotFoundException("User with Id : "+Id+" not found");
		}
		
	}

	@Override
	public void saveUser(User u) {
		// u.setPassword(passwordEncoder.encode(u.getPassword()));
	      userrepo.save(u);
			
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> l = userrepo.findAll();
		return l;
	}

	@Override
	public List<User> getByEmail(String email) {
		return userrepo.findByEmail(email);
	}

}
