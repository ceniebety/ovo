package com.example.ovo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ovo.model.User;
import com.example.ovo.repository.UserRepository;

@RestController
@RequestMapping("/ovo")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@PostMapping(value = "/CreateUser")
	public User createUser(@Valid @RequestBody User user) {
		 return userRepository.save(user);
	}
	
	@DeleteMapping("/DeleteUser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new com.example.ovo.exception.ResourceNotFoundException("User", "id", userId));

        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
	
	 @PostMapping("/UpdateUser/{id}")
	    public User updateUser(@PathVariable(value = "id") Long userId,
	                                           @Valid @RequestBody User userDetails) {

	        User user = userRepository.findById(userId)
	                .orElseThrow(() -> new com.example.ovo.exception.ResourceNotFoundException("User", "id", userId));

	        user.setFullname(userDetails.getFullname());
	        user.setUsername(userDetails.getUsername());
	        user.setPassword(userDetails.getPassword());

	        User updatedUser = userRepository.save(user);
	        return updatedUser;
	    }
}
