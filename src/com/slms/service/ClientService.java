package com.slms.service;

import java.util.List;

import org.hibernate.Session;

import com.slms.dao.DBConnection;
import com.slms.dao.DBHandleDao;
import com.slms.domain.Client;

public class ClientService extends DBConnection implements DBHandleDao<Client> {
	
	@Override
	public int save(Client obj) {
		int id=-1;
		Session session=sessionFactory.getCurrentSession();
		id=(int) session.save(obj);
		return id;
	}

	@Override
	public void update(Client obj) {
		Session session=sessionFactory.getCurrentSession();
		session.update(obj);
	}

	@Override
	public Client queryId(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Client) session.get(Client.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> queryHQL(String HQL) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery(HQL).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Client> queryAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Client").list();
	}

	@Override
	public void delete(Client obj) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(obj);
	}

}
