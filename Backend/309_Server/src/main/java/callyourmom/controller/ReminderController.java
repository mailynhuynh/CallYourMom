package callyourmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import callyourmom.service.ReminderService;
import callyourmom.user.Reminder;

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
}