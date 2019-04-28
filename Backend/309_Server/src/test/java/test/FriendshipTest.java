package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import callyourmom.repository.FriendshipRepository;
import callyourmom.service.FriendshipService;
import callyourmom.user.Friendship;

public class FriendshipTest {

	@InjectMocks
	FriendshipService friendshipService;
	
	@Mock
	FriendshipRepository friendshipRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getFriendshipByIdTest() {
		Friendship friendship = new Friendship();
		friendship.setId(1);
		friendship.setFriendId(3);
		when(friendshipRepository.getOne(1)).thenReturn(friendship);

		Friendship friend = friendshipService.get(1);

		Integer id = 1;
		Integer friendId = 3;
		assertEquals(id, friend.getId());
		assertEquals(friendId, friend.getFriendId());
	}
	
	@Test
	public void getAllFriendshipTest() {
		List<Friendship> list = new ArrayList<Friendship>();
		Friendship friendship1 = new Friendship();
		Friendship friendship2 = new Friendship();
		Friendship friendship3 = new Friendship();

		list.add(friendship1);
		list.add(friendship2);
		list.add(friendship3);

		when(friendshipRepository.findAll()).thenReturn(list);

		List<Friendship> friendshipList = friendshipService.getAll();

		assertEquals(3, friendshipList.size());
		verify(friendshipRepository, times(1)).findAll();

	}
	
	@Test
	public void createFriendshipTest() {
		Friendship friendship = new Friendship();
		friendship.setId(3);
		friendship.setFriendId(2);
		
		when(friendshipRepository.save(friendship)).thenReturn(friendship);	
		Friendship friend = friendshipService.create(friendship);
		Integer result = friend.getFriendId();
		Integer expected = 2;
		assertEquals(expected, result);
	}
}
