package com.emilio.projects.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import static org.mockito.Mockito.*;

public class VoterTestCase extends PersistenceBaseClass {
	
	public void testCreateFind() throws Exception {
		Voter v = new Voter();
		Calendar c = new GregorianCalendar();
		User u = mock(User.class);
		Event e = mock(Event.class);
		c.set(2014, 1, 23, 11, 9);
		Date d1 = c.getTime();
		v.setEnrollmentTime(d1);
		c.set(2014, 1, 23, 11, 18);
		Date d2 = c.getTime();
		v.setVoteRecordedTime(d2);
		v.setUser(u);
		v.setEvent(e);
		entityMgr.persist(v);
		entityMgr.flush();
		Voter test = entityMgr.find(Voter.class,v.getId());
		assertNotNull(test);
		assertEquals(v.getEnrollmentTime(),test.getEnrollmentTime());
		assertEquals(v.getVoteRecordedTime(),test.getVoteRecordedTime());
		assertEquals(v.getUser(), test.getUser());
		assertEquals(v.getEvent(), test.getEvent());
	}	

}
