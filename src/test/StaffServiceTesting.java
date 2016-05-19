package test;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.slms.dao.DBHandleDao;
import com.slms.domain.Staff;
import com.slms.tools.AppContextUtil;

/**
 * StaffService的后台业务逻辑操作类测试
 * @author overlord
 *
 */
public class StaffServiceTesting {

	static DBHandleDao<Staff> service;
	static int id=-1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service=AppContextUtil.getServiceBean("staffService");
	}

	/**
	 * 测试Staff从Service级到数据库的操作，存入新数据对象
	 */
	@Test
	public void test1() {
		Staff staff=new Staff();
		staff.setName("测试1");
		staff.setSex((byte) 0);
		staff.setBirth(new Date());
		id=service.save(staff);
		System.out.println("test1.id="+id);
	}
	
	/**
	 * 取出、修改，并更新数据对象
	 */
	@Test
	public void test2(){
		Staff staff=service.queryId(1);
		staff.setName("测试修改2");
		service.update(staff);
		System.out.println("test2.result="+service.queryId(staff.getId()).getName());
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
		List<Staff> li=service.queryAll();
		for(Staff staff:li){
			System.out.println("test3: id="+staff.getId()+" name="+staff.getName());
		}
	}

}
