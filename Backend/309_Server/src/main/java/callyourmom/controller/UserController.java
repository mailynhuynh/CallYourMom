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
	
	/**
	 * Gets a list of all the users
	 * @return user
	 */
	@GetMapping("/users")
	List<User> get() {
	    return userService.getAll();
	}
	
	/**
	 * Gets a user specified by it's id
	 * @param the id 
	 * @return user
	 */
	@GetMapping("/users/{id}")
	User get(@PathVariable Integer id) {
	    return userService.get(id);
	}

	/**
	 * Adds a user
	 * @param the user
	 * @return user
	 */
	@PostMapping("/users")
	User post(@RequestBody User user) {
	    return userService.create(user);
	}
	
	
	
	
	
//	@GetMapping("/users/friends/{id}")
//	List<User> getFriends(@PathVariable Integer id){
//		return userService.getFriends(id);
//	
//	}
//	
//	@PostMapping("/users/friend")
//	void addFriend(@RequestBody Integer id) {
//		userService.addFriend(id);
//	}
	
	
	
	
	
}