package callyourmom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import callyourmom.service.SettingsService;
import callyourmom.user.Settings;

@RestController
public class SettingsController {
	@Autowired // @Autowired attribute injects UserService into this class
	SettingsService settingsService;
	
	/**
	 * 
	 * @return gets the settings for all of the users
	 */
	@GetMapping("/settings")
	List<Settings> get() {
	    return settingsService.getAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return gets the settings for a particular user by it's id
	 */
	@GetMapping("/settings/{id}")
	Settings get(@PathVariable Integer id) {
	    return settingsService.get(id);
	}

	/**
	 * 
	 * @param setting
	 * @return adds a setting configuration for a particular user
	 */
	@PostMapping("/settings")
	Settings post(@RequestBody Settings setting) {
	    return settingsService.create(setting);
	}
}