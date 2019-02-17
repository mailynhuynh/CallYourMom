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
	UserService userService;
	
	@GetMapping("/users")
	List<User> get() {
	    return userService.getAll();
	}
	
	@GetMapping("/users/{id}")
	User get(@PathVariable long id) {
	    return userService.get(id);
	}

	@PostMapping("/users")
	User post(@RequestBody User user) {
	    return userService.create(user);
	}
}