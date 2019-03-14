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
	
	@GetMapping("/settings")
	List<Settings> get() {
	    return settingsService.getAll();
	}
	
	@GetMapping("/settings/{id}")
	Settings get(@PathVariable Integer id) {
	    return settingsService.get(id);
	}

	@PostMapping("/settings")
	Settings post(@RequestBody Settings setting) {
	    return settingsService.create(setting);
	}
}