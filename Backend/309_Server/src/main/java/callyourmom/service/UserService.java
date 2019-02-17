package callyourmom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import callyourmom.repository.UserRepository;
import callyourmom.user.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User get(long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}

	public User create(User user) {
		return userRepository.save(user);
	}

}
