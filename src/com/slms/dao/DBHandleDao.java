package com.slms.dao;

import java.util.List;

public interface DBHandleDao<E> {
	/**
	 * 存入一条新数据实体
	 * @param obj
	 * @return	分配的id
	 */
	int save(E obj);
	/**
	 * 更新一条已有数据实体
	 * @param obj
	 */
	void update(E obj);
	/**
	 * 按id获取一条该类型数据实体
	 * @param id
	 * @return	该实体
	 */
	E queryId(int id);
	/**
	 * 按HQL语句获取符合条件的该类型数据实体列表
	 * @param name
	 * @return	列表
	 */
	List<E> queryHQL(String HQL);
	/**
	 * 获取单张关系表的所有该类型数据实体列表
	 * @return	列表
	 */
	List<E> queryAll();
	/**
	 * 按id删除一条实体
	 * @param id
	 */
	void delete(E obj);
}
