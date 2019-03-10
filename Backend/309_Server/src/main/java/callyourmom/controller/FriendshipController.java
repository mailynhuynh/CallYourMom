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
	
	@GetMapping("/friendship")
	List<Friendship> get() {
	    return FriendshipService.getAll();
	}
	
	@GetMapping("/friendship/{id}")
	Friendship get(@PathVariable Integer id) {
	    return FriendshipService.get(id);
	}

	@PostMapping("/friendship")
	Friendship post(@RequestBody Friendship f) {
	    return FriendshipService.create(f);
	}
}