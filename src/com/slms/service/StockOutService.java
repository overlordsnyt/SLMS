package com.slms.service;

import java.util.List;

import org.hibernate.Session;

import com.slms.dao.DBConnection;
import com.slms.dao.DBHandleDao;
import com.slms.domain.StockOut;

public class StockOutService extends DBConnection implements DBHandleDao<StockOut> {

	@Override
	public int save(StockOut obj) {
		int id=-1;
		Session session=sessionFactory.getCurrentSession();
		id=(int) session.save(obj);
		return id;
	}

	@Override
	public void update(StockOut obj) {
		Session session=sessionFactory.getCurrentSession();
		session.update(obj);
	}

	@Override
	public StockOut queryId(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (StockOut) session.get(StockOut.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockOut> queryHQL(String HQL) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery(HQL).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StockOut> queryAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from StockOut").list();
	}

	@Override
	public void delete(StockOut obj) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(obj);
	}

}
