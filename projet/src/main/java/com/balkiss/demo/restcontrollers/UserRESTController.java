package com.balkiss.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balkiss.demo.entities.User;
import com.balkiss.demo.repos.UserRepository;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserRESTController {
	@Autowired
	UserRepository userRepository;

	@GetMapping
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable("id") Long id) {
		return userRepository.findById(id).get();
	}

}
