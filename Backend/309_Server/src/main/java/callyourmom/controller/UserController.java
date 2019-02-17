package callyourmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import callyourmom.repository.UserRepository;
import callyourmom.service.UserService;
import callyourmom.user.User;

@RestController
public class UserController {
	@Autowired // @Autowired attribute injects UserService into this class
	UserRepository userRepository;
	
	@GetMapping("/users")
	Iterable<User> get() {
	    return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	User get(@PathVariable long id) {
	    return userRepository.findById(id).get();
	}

	@PostMapping("/users")
	User post(@RequestBody User user) {
	    return userRepository.save(user);
	}
}