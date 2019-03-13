package callyourmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import callyourmom.service.ReminderService;
import callyourmom.user.Reminder;
import callyourmom.user.User;

@RestController
public class ReminderController {
	@Autowired // @Autowired attribute injects UserService into this class
	ReminderService reminderService;
	
	@GetMapping("/reminders")
	List<Reminder> get() {
	    return reminderService.getAll();
	}
	
	@GetMapping("/reminders/{id}")
	Reminder get(@PathVariable Integer id) {
	    return reminderService.get(id);
	}
	
	@PostMapping("/reminders")
	Reminder post(@RequestBody Reminder reminder) {
	    return reminderService.create(reminder);
	}
	
}