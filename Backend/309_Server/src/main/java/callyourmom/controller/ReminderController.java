package callyourmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import callyourmom.service.EventService;
import callyourmom.user.Event;

@RestController
public class ReminderController {
	@Autowired // @Autowired attribute injects UserService into this class
	EventService reminderService;
	
	@GetMapping("/reminders")
	List<Event> get() {
	    return reminderService.getAll();
	}
	
	@GetMapping("/events/{id}")
	Event get(@PathVariable Integer id) {
	    return reminderService.get(id);
	}

	@PostMapping("/events")
	Event post(@RequestBody Event event) {
	    return reminderService.create(event);
	}
}