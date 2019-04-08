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

import callyourmom.repository.*;
import callyourmom.service.*;
import callyourmom.user.*;

public class UserTest {

	@InjectMocks
	UserService service;

	@Mock
	UserRepository repo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		User r = new User();
		r.setId(1);

	}

	@Test
	public void getUserByIDTest() {

		User r = new User();
		r.setId(1);
		r.setUserName("Zoe~");

		when(repo.getOne(1)).thenReturn(r);

		User result = service.get(1);
		assertEquals("Zoe~", result.getUserName());
	}

	@Test
	public void getAllUserTest() {

		List<User> rList = new ArrayList<>();
		User r1 = new User();
		User r2 = new User();
		User r3 = new User();

		rList.add(r1);
		rList.add(r2);
		rList.add(r3);

		when(repo.findAll()).thenReturn(rList);
		List<User> result = service.getAll();
		assertEquals(rList, result);
	}

	@Test
	public void createUserTest() {

		User newUser = new User();
		newUser.setId(3);
		newUser.setUserName("I'm a new user");

		when(repo.save(newUser)).thenReturn(newUser);
		User result = service.create(newUser);
		String un = result.getUserName();
		assertEquals("I'm a new user", un);
	}

}

