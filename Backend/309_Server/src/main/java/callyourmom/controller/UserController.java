package callyourmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
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
	User get(@PathVariable Integer id) {
	    return userService.get(id);
	}

	@PostMapping("/users")
	User post(@RequestBody User user) {
	    return userService.create(user);
	}
	
	@GetMapping("/users/{id}")
	List<User> getFriends(@PathVariable Integer id){
		return userService.getFriends(id);
	
	}
	
	@PostMapping("/users")
	void addFriend(@RequestBody Integer id) {
		userService.addFriend(id);
	}
	
	
	
	
	
}