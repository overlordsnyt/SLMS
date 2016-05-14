package com.slms.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.slms.dao.DaoTest;
import com.slms.domain.ConnectionTest;

/**
 * 创建ApplicationContext的一键化静态工具类
 * @author overlord
 *
 */
public class AppContextUtil {
	/**
	 * 一键创建ApplicationContext
	 * @param beanName 在bean.xml中配置好的数据库操作实例bean的名称
	 * @return		创建完成的对应类型的数据库操作实例
	 */
	public static <E> DaoTest<E> getHandleBean(String beanName){
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		@SuppressWarnings("unchecked")
		DaoTest<E> handle=(DaoTest<E>)context.getBean(beanName);
		return handle;
	}
	
	/**
	 * 测试此类能否通过beanName名创建到dao数据库操作类的实现类实例
	 * 出现错误：配置<aop:config><aop:pointcut expression="">时表达式路径搞错
	 * @param args
	 */
	public static void main(String args[]){
		DaoTest<ConnectionTest> tt=getHandleBean("connectiontest");
		System.out.println(tt.getClass());
		ConnectionTest vo=new ConnectionTest();
		vo.setUsername("555");
		vo.setPassword("ppp");
		int result=tt.savetest(vo);
		System.out.println(result);
	}

}
