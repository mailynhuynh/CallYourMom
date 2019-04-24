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
	 * 
	 * @return a list of all the friendships
	 */
	@GetMapping("/friendship")
	List<Friendship> get() {
	    return FriendshipService.getAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return the friendship that is specified by it's id
	 */
	@GetMapping("/friendship/{id}")
	Friendship get(@PathVariable Integer id) {
	    return FriendshipService.get(id);
	}

	/**
	 * 
	 * @param f
	 * @return adds a friendship
	 */
	@PostMapping("/friendship")
	Friendship post(@RequestBody Friendship f) {
	    return FriendshipService.create(f);
	}
	
	/**
	 * 
	 * @param id
	 * @return checks what the relationship of the friendship is
	 */
	@GetMapping("/friendship/friend/{id}")
	User getFriend(@PathVariable Integer id) {
	    return FriendshipService.getFriend(id);
	}
	
	
}