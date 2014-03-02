package com.emilio.projects.user;

import javax.persistence.*;

import com.emilio.projects.model.User;

public class UserServiceImpl implements com.emilio.projects.user.UserService {
	
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
		entityMgr.flush();
		tx.commit();
		return u;
	}

	public void persistUser(User user)  {
		EntityTransaction tx = entityMgr.getTransaction();		
		tx.begin();
		try {
			entityMgr.persist(user);
			entityMgr.flush();
		} catch(RollbackException e) {
			//tx.rollback();
			throw (RuntimeException)e.getCause();
		}
		tx.commit();		

	}

}
