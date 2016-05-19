package com.slms.service;

import java.util.List;

import org.hibernate.Session;

import com.slms.dao.DBConnection;
import com.slms.dao.DBHandleDao;
import com.slms.domain.Staff;

/**
 * Staff员工档案相关的数据库操作实现类
 * @author overlord	
 *	继承整合Spring的SessionFactory管理的DBConnection类
 *	实现DBHandleDao规定的接口
 */
public class StaffService extends DBConnection implements DBHandleDao<Staff> {

	@Override
	public int save(Staff obj) {
		int id=-1;
		Session session=sessionFactory.getCurrentSession();
		id=(int)session.save(obj);
		return id;
	}

	@Override
	public void update(Staff obj) {
		Session session=sessionFactory.getCurrentSession();
		session.update(obj);
	}

	@Override
	public Staff queryId(int id) {
		Session session=sessionFactory.getCurrentSession();
		return (Staff) session.get(Staff.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> queryHQL(String HQL) {
		Session session=sessionFactory.getCurrentSession();
		return session.createQuery(HQL).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Staff> queryAll() {
		Session session=sessionFactory.getCurrentSession();
		//HQL查询的取数据实体类名需与hbm.xml里声明的一致
		return session.createQuery("from Staff").list();
	}

	@Override
	public void delete(Staff obj) {
		Session session=sessionFactory.getCurrentSession();
		session.delete(obj);
	}

}
