package callyourmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import callyourmom.repository.EventRepository;
import callyourmom.repository.*;
import callyourmom.user.Event;
import callyourmom.user.Friendship;
import callyourmom.user.User;

@Service
public class FriendshipService {
	
	@Autowired
	FriendshipRepository FriendshipRepository;
	
	UserRepository userRepository;

	public List<Friendship> getAll() {
		return FriendshipRepository.findAll();
	}

	public Friendship get(Integer id) {
		return FriendshipRepository.getOne(id);
	}
	
	public User getFriend(Integer id) {
		return userRepository.getOne(id);	
	}
	

	public Friendship create(Friendship f) {
		return FriendshipRepository.save(f);
	}
}