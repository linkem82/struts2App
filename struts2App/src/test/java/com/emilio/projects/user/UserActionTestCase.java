package com.emilio.projects.user;

import com.emilio.projects.model.User;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class UserActionTestCase extends TestCase {
	
	UserAction ua;
	String email;
	UserService us;
	User testUser;

	protected void setUp() throws Exception {
		super.setUp();
		ua = new UserAction();
		email = "emilio@gmail.com";
		testUser = new User();
		testUser.setEmail(email);
		us = mock(UserService.class);
		when(us.getUserByEmail(email)).thenReturn(testUser);
		ua.setService(us);		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPrepare() throws Exception {
		ua.setEmailId(null);
		ua.prepare();
		assertNotNull(ua.getUser());
		assertEquals(ua.getUser(), new User());
		ua.setEmailId(email);		
		ua.prepare();
		assertEquals(ua.getUser(), testUser);		
	}
	
	public void testFind() {
		assertEquals(ua.find(), com.opensymphony.xwork2.Action.INPUT);
	}
	
	public void testUpdate() {
		assertEquals(ua.update(), com.opensymphony.xwork2.Action.SUCCESS);
	}
	
	public void testGetModel() {
		ua.setUser(testUser);
		assertEquals(ua.getModel(), testUser);
	}

}
