package test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.slms.dao.DBHandleDao;
import com.slms.domain.StockIn;
import com.slms.tools.AppContextUtil;

/**
 * StockInService的后台业务逻辑操作类测试
 * @author overlord
 *
 */
public class StockInServiceTesting {

	static DBHandleDao<StockIn> service;
	static int id=-1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service=AppContextUtil.getServiceBean("stockinService");
	}

	/**
	 * 测试StockIn从Service级到数据库的操作，存入新数据对象
	 */
	@Test
	public void test1() {
		StockIn stockin=new StockIn();
		stockin.setName("测试1");
		id=service.save(stockin);
		System.out.println("test1.id="+id);
	}
	
	/**
	 * 取出、修改，并更新数据对象
	 */
	@Test
	public void test2(){
		StockIn stockin=service.queryId(1);
		stockin.setName("测试修改2");
		service.update(stockin);
		System.out.println("test2.result="+service.queryId(stockin.getId()).getName());
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
		List<StockIn> li=service.queryAll();
		for(StockIn stockin:li){
			System.out.println("test3: id="+stockin.getId()+" name="+stockin.getName());
		}
	}

}
