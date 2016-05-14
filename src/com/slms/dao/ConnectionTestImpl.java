package com.slms.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.slms.domain.ConnectionTest;
/**
 * 通过spring+hibernate实现数据库操作的测试dao实现类
 * @author overlord
 *
 */
public class ConnectionTestImpl implements DaoTest<ConnectionTest> {
	private SessionFactory sessionFactory;
	@Override
	public int savetest(ConnectionTest obj) {
		int id=-1;
		Session session=sessionFactory.getCurrentSession();
		//hint：AOP自动处理事务，无须在dao数据库操作方法里重新开启并提交事务
//		Transaction tx=session.beginTransaction();
		id=(int) session.save(obj);
//		tx.commit();
		return id;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
