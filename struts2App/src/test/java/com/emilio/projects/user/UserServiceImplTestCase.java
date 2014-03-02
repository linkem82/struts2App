package com.emilio.projects.user;

import javax.persistence.*;

import com.emilio.projects.model.User;
import com.emilio.projects.user.UserService;

import junit.framework.TestCase;

public class UserServiceImplTestCase extends TestCase {
	
	private User u;
	
	public void testPersistFindByEmail() {
		UserService uServ = new UserServiceImpl();
		uServ.persistUser(u);
		User test = uServ.getUserByEmail("emilio@gmail.com");		
		assertEquals(u, test);
	}
	
	protected void setUp() throws Exception {
		u = new User();
		u.setEmail("emilio@gmail.com");
	}
	
	protected void tearDown() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("xe");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(u));
		em.getTransaction().commit();		
	}

}
