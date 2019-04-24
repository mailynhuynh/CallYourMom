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
	 * 
	 * @return gets all of the reminders
	 */
	@GetMapping("/reminders")
	List<Reminder> get() {
	    return reminderService.getAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return gets a specific reminderService by it's id
	 */
	@GetMapping("/reminders/{id}")
	Reminder get(@PathVariable Integer id) {
	    return reminderService.get(id);
	}
	
	/**
	 * 
	 * @param reminder
	 * @return adds a reminder
	 */
	@PostMapping("/reminders")
	Reminder post(@RequestBody Reminder reminder) {
	    return reminderService.create(reminder);
	}
	
	
	
	
}