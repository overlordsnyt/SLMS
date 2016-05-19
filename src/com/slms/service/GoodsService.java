package com.slms.service;

import java.util.List;

import org.hibernate.Session;

import com.slms.dao.DBConnection;
import com.slms.dao.DBHandleDao;
import com.slms.domain.Goods;

public class GoodsService extends DBConnection implements DBHandleDao<Goods> {

	@Override
	public int save(Goods obj) {
		int id=-1;
		Session session=sessionFactory.getCurrentSession();
		id=(int) session.save(obj);
		return id;
	}

	@Override
	public void update(Goods obj) {
		Session session=sessionFactory.getCurrentSession();
		session.update(obj);
	}

	@Override
	public Goods queryId(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Goods) session.get(Goods.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> queryHQL(String HQL) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery(HQL).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> queryAll() {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from Goods").list();
	}

	@Override
	public void delete(Goods obj) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(obj);
	}

}
