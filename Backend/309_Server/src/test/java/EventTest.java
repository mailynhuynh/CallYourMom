

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

public class EventTest {

	@InjectMocks
	EventService service;

	@Mock
	EventRepository repo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		Event r = new Event();
		r.setId(1);

	}

	@Test
	public void getEventByIDTest() {

		Event r = new Event();
		r.setId(1);
		r.setTitle("MockitoTest1");

		when(repo.getOne(1)).thenReturn(r);

		Event result = service.get(1);
		assertEquals("MockitoTest1", result.getTitle());
	}

	@Test
	public void getAllEventTest() {

		List<Event> rList = new ArrayList<>();
		Event r1 = new Event();
		Event r2 = new Event();
		Event r3 = new Event();

		rList.add(r1);
		rList.add(r2);
		rList.add(r3);

		when(repo.findAll()).thenReturn(rList);
		List<Event> result = service.getAll();
		assertEquals(rList, result);
	}

	@Test
	public void createEventTest() {

		Event newEvent = new Event();
		newEvent.setId(3);
		newEvent.setTitle("MockitoTest3");

		when(repo.save(newEvent)).thenReturn(newEvent);
		Event result = service.create(newEvent);
		String title = result.getTitle();
		assertEquals("MockitoTest3", title);
	}

}
