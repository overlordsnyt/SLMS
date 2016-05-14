package test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.slms.dao.ConnectionTestImpl;
import com.slms.dao.DaoTest;
import com.slms.domain.ConnectionTest;

public class ConnectionTesting {
	static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(context!=null);
	}

	@Test
	public void test1() {
		@SuppressWarnings("unchecked")
		DaoTest<ConnectionTest> handle=(DaoTest<ConnectionTest>) context.getBean("connectiontest");
		ConnectionTest vo=new ConnectionTest();
		vo.setUsername("333");
		vo.setPassword("ppp");
		int result=handle.savetest(vo);
		System.out.println(result);
	}

}
