package callyourmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import callyourmom.service.*;
import callyourmom.user.*;

@RestController
public class FriendshipController {
	@Autowired // @Autowired attribute injects UserService into this class
	FriendshipService FriendshipService;
	
	/**
	 * Gets a list of all the friendships
	 * @return all of the friendships
	 */
	@GetMapping("/friendship")
	List<Friendship> get() {
	    return FriendshipService.getAll();
	}
	
	/**
	 * Gets a friendship by it's individual id
	 * @param id
	 * @return a friendship
	 */
	@GetMapping("/friendship/{id}")
	Friendship get(@PathVariable Integer id) {
	    return FriendshipService.get(id);
	}

	/**
	 * Adds a friendship
	 * @param f
	 * @return a friendship
	 */
	@PostMapping("/friendship")
	Friendship post(@RequestBody Friendship f) {
	    return FriendshipService.create(f);
	}
	
	/**
	 * Gets a user based on it's friendship id
	 * @param id
	 * @return a user
	 */
	@GetMapping("/friendship/friend/{id}")
	User getFriend(@PathVariable Integer id) {
	    return FriendshipService.getFriend(id);
	}
	
	
}