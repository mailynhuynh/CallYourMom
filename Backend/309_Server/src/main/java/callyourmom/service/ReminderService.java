package callyourmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import callyourmom.repository.ReminderRepository;
import callyourmom.user.Reminder;

@Service
public class ReminderService {
	
	@Autowired
	ReminderRepository reminderRepository;

	public List<Reminder> getAll() {
		return reminderRepository.findAll();
	}

	public Reminder get(Integer id) {
		return reminderRepository.getOne(id);
	}

	public Reminder create(Reminder reminder) {
		return reminderRepository.save(reminder);
	}
}
