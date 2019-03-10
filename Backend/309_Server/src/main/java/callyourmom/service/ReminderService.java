package callyourmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import callyourmom.repository.EventRepository;
import callyourmom.user.Event;

@Service
public class ReminderService {
	
	@Autowired
	EventRepository reminderRepository;

	public List<Event> getAll() {
		return reminderRepository.findAll();
	}

	public Event get(Integer id) {
		return reminderRepository.getOne(id);
	}

	public Event create(Event event) {
		return reminderRepository.save(event);
	}
}
