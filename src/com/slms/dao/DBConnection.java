package com.slms.dao;

import org.hibernate.SessionFactory;

public class DBConnection {
	protected SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
