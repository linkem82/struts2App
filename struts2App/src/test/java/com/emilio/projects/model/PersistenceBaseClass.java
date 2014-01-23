package com.emilio.projects.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import junit.framework.TestCase;

public class PersistenceBaseClass extends TestCase{
	
	private EntityManagerFactory emf;
	protected EntityManager entityMgr;
	protected EntityTransaction tx;
	
	public PersistenceBaseClass() {
		super();
		emf = Persistence.createEntityManagerFactory("xe");
	}
	protected void setUp() throws Exception {
		super.setUp();
		entityMgr = emf.createEntityManager();
		tx = entityMgr.getTransaction();
		tx.begin();
	}
	protected void tearDown() throws Exception {
		super.tearDown();
		tx.rollback();
	}

}
