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
	 * Gets all of the settings
	 * @return a list of setting objects
	 */
	@GetMapping("/settings")
	List<Settings> get() {
	    return settingsService.getAll();
	}
	
	/**
	 * Gets a specific setting based on it's id
	 * @param id
	 * @return a setting
	 */
	@GetMapping("/settings/{id}")
	Settings get(@PathVariable Integer id) {
	    return settingsService.get(id);
	}

	/**
	 * Adds a setting configuration
	 * @param setting
	 * @return a setting
	 */
	@PostMapping("/settings")
	Settings post(@RequestBody Settings setting) {
	    return settingsService.create(setting);
	}
}