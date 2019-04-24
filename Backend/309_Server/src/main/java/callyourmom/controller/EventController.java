package callyourmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import callyourmom.service.EventService;
import callyourmom.user.Event;

@RestController
public class EventController {
	@Autowired // @Autowired attribute injects UserService into this class
	EventService eventService;
	
	/**
	 * @return a list of all the events
	 */
	@GetMapping("/events")
	List<Event> get() {
	    return eventService.getAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return the event that is specified by it's id
	 */
	@GetMapping("/events/{id}")
	Event get(@PathVariable Integer id) {
	    return eventService.get(id);
	}

	/**
	 * 
	 * @param event
	 * @return adds an event
	 */
	@PostMapping("/events")
	Event post(@RequestBody Event event) {
	    return eventService.create(event);
	}
}