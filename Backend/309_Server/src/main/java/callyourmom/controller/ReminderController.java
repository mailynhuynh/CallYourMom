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
	
	/**
	 * Gets all of the reminders
	 * @return a reminder
	 */
	@GetMapping("/reminders")
	List<Reminder> get() {
	    return reminderService.getAll();
	}
	
	/**
	 * Gets a reminder specified by id
	 * @param id
	 * @return a reminder
	 */
	@GetMapping("/reminders/{id}")
	Reminder get(@PathVariable Integer id) {
	    return reminderService.get(id);
	}
	
	/**
	 * Adds a reminder
	 * @param reminder
	 * @return a reminder
	 */
	@PostMapping("/reminders")
	Reminder post(@RequestBody Reminder reminder) {
	    return reminderService.create(reminder);
	}
}