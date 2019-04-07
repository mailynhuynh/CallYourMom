package callyourmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import callyourmom.repository.EventRepository;
import callyourmom.user.Event;

@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepository;

	public List<Event> getAll() {
		return eventRepository.findAll();
	}

	public Event get(Integer id) {
		return eventRepository.getOne(id);
	}

	public Event create(Event event) {
		return eventRepository.save(event);
	}
}
