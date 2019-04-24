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
	 * 
	 * @return a user
	 */
	@GetMapping("/users")
	List<User> get() {
	    return userService.getAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return a user by it's specified id
	 */
	@GetMapping("/users/{id}")
	User get(@PathVariable Integer id) {
	    return userService.get(id);
	}

	/**
	 * 
	 * @param user
	 * @return adds a user 
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