package callyourmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import callyourmom.repository.SettingsRepository;
import callyourmom.user.Settings;

@Service
public class SettingsService {
	
	@Autowired
	SettingsRepository settingsRepository;

	public List<Settings> getAll() {
		return settingsRepository.findAll();
	}

	public Settings get(Integer id) {
		return settingsRepository.getOne(id);
	}

	public Settings create(Settings settings) {
		return settingsRepository.save(settings);
	}
}
