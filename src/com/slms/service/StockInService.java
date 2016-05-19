package com.slms.service;

import java.util.List;

import org.hibernate.Session;

import com.slms.dao.DBConnection;
import com.slms.dao.DBHandleDao;
import com.slms.domain.StockIn;

public class StockInService extends DBConnection implements DBHandleDao<StockIn> {

	@Override
	public int save(StockIn obj) {
		int id=-1;
		Session session=sessionFactory.getCurrentSession();
		id=(int) session.save(obj);
		return id;
	}

	@Override
	public void update(StockIn obj) {
		Session session=sessionFactory.getCurrentSession();
		session.update(obj);
	}

	@Override
	public StockIn queryId(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (StockIn) session.get(StockIn.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockIn> queryHQL(String HQL) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery(HQL).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockIn> queryAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from StockIn").list();
	}

	@Override
	public void delete(StockIn obj) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(obj);
	}

}
