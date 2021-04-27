package com.cognixia.jump.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.springboot.repository.UserRepository;
import com.cognixia.jump.springboot.model.User;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
    private UserRepository user;
	
	@GetMapping("/users")
	public List<User> getAllUsers() {
		
		return user.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable long id) {
		
		Optional<User> userOpt = user.findById(id);
		
		if(userOpt.isPresent()) {
			return userOpt.get();
		}
		
		return new User();
	}
	
	@PostMapping("/add/user")
	public void addUser(@RequestBody User newUser) {
		
		newUser.setId(-1L);
		
		User added = user.save(newUser); // save() does an insert or update (depends on id passed)
		
		System.out.println("Added: " + added);
		
	}
	
	@DeleteMapping("/delete/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable long id) {
		
		Optional<User> found = user.findById(id);
		
		if(found.isPresent()) {
			
			user.deleteById(id);
			
			return ResponseEntity.status(200).body("Deleted user with id = " + id);	
		}
		else {
			return ResponseEntity.status(400)
					.header("user id", id + "")
					.body("User with id = " + id + " not found");
		}
			
	}

}
