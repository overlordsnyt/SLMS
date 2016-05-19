package test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.slms.dao.DBHandleDao;
import com.slms.domain.Client;
import com.slms.tools.AppContextUtil;

/**
 * ClientService的后台业务逻辑操作类测试
 * @author overlord
 *
 */
public class ClientServiceTesting {

	static DBHandleDao<Client> service;
	static int id=-1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service=AppContextUtil.getServiceBean("clientService");
	}

	/**
	 * 测试Client从Service级到数据库的操作，存入新数据对象
	 */
	@Test
	public void test1() {
		Client client=new Client();
		client.setName("测试1");
		id=service.save(client);
		System.out.println("test1.id="+id);
	}
	
	/**
	 * 取出、修改，并更新数据对象
	 */
	@Test
	public void test2(){
		Client client=service.queryId(1);
		client.setName("测试修改2");
		service.update(client);
		System.out.println("test2.result="+service.queryId(client.getId()).getName());
	}
	
	/**
	 * 删除一条数据对象
	 */
	@Test
	public void test3(){
		service.delete(service.queryId(id));
	}
	
	/**
	 * 查询此类型所有数据对象
	 */
	@Test
	public void test4(){
		List<Client> li=service.queryAll();
		for(Client client:li){
			System.out.println("test3: id="+client.getId()+" name="+client.getName());
		}
	}

}
