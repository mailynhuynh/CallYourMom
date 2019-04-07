package callyourmom.service;

import java.util.ArrayList;
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

	public User get(Integer id) {
		return userRepository.getOne(id);
	}

	public User create(User user) {
		return userRepository.save(user);
	}
	
//	/**
//	 * Edit: Mar 10
//	 * The method to get all friends of a user
//	 * @param id
//	 * @return
//	 */
//	public List<User> getFriends(Integer id){
//		
//		User u = userRepository.getOne(id);
//		ArrayList<Integer> friends = u.getFriends();
//		
//		List<User> result = new ArrayList<User>();
//		for (int i : friends) {
//			result.add(userRepository.getOne(i));
//		}
//		return result;
//	}
//	
//	
//	/**
//	 * Edit: Mar 10
//	 * add a new friend to an user
//	 * @param id
//	 */
//	public void addFriend(Integer id){
//		User newFriend = userRepository.getOne(id);
//		newFriend.setFriend(id);		
//	}
}
