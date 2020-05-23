package com.ms.travel.social.users.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ms.travel.social.users.exception.UserNotFoundException;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repository;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return repository.findAll();
	}

	@PostMapping("/users/create")
	public ResponseEntity<Object> saveUser(@RequestBody User traveller){
		User savedTraveller = repository.save(traveller);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedTraveller.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable Long id) {
		Optional<User> traveller = repository.findById(id);
		if (!traveller.isPresent()) 
			throw new UserNotFoundException("id"+id);
		return traveller;
	}
	
	@DeleteMapping("/users/{id}")
	public Object deleteUser(@PathVariable Long id) {
		if (id!=null)
			repository.deleteById(id);
		return null;
	}

}
