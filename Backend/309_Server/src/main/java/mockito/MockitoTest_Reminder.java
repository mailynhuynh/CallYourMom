package mockito;

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


import callyourmom.repository.ReminderRepository;
import callyourmom.service.ReminderService;
import callyourmom.user.Reminder;

public class MockitoTest_Reminder {

	@InjectMocks
	ReminderService service;

	@Mock
	ReminderRepository repo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		Reminder r = new Reminder();
		r.setId(1);
		
		
	}

	@Test
	public void getReminderByIDTest() {
		
		Reminder r = new Reminder();
		r.setId(1);
		r.setTitle("MockitoTest1");
				
		when(repo.getOne(1)).thenReturn(r);
		
		Reminder result = service.get(1);	
		assertEquals("MockitoTest1", result.getTitle());
	}
	
	
	@Test
	public void getAllReminderTest() {
		
		List<Reminder> rList = new ArrayList<>();
		Reminder r1 = new Reminder();
		Reminder r2 = new Reminder();
		Reminder r3 = new Reminder();
			
		rList.add(r1);
		rList.add(r2);
		rList.add(r3);
		
		when(repo.findAll()).thenReturn(rList);		
		List<Reminder> result = service.getAll();			
		assertEquals(rList, result);
	}
	
	
	@Test
	public void createReminderTest() {
		
		Reminder newR = new Reminder();
		newR.setId(3);
		newR.setTitle("MockitoTest3");
		
		when(repo.save(newR)).thenReturn(newR);	
		Reminder result = service.create(newR);
		String title = result.getTitle();		
		assertEquals("MockitoTest3", title);
	}

}
