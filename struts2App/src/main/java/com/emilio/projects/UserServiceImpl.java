package com.emilio.projects;

import javax.persistence.*;
import com.emilio.projects.model.User;

public class UserServiceImpl implements UserService {
	
	private EntityManagerFactory emf;
	private EntityManager entityMgr;
		
	public UserServiceImpl() {
		emf = Persistence.createEntityManagerFactory("xe");
		entityMgr = emf.createEntityManager();
	}
	
	public User getUserByEmail(String email) {
		EntityTransaction tx = entityMgr.getTransaction();		
		tx.begin();
		Query q = (Query) entityMgr.createNamedQuery("user.byEmail");
		q.setParameter("email", email);
		User u = (User)q.getSingleResult();
		//entityMgr.flush();
		return u;
	}

	public void persistUser(User user) {
		EntityTransaction tx = entityMgr.getTransaction();		
		tx.begin();
		entityMgr.persist(user);
		//entityMgr.flush();
		tx.commit();		

	}

}
