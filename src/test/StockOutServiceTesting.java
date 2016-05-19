package test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.slms.dao.DBHandleDao;
import com.slms.domain.StockOut;
import com.slms.tools.AppContextUtil;

/**
 * StockOutService的后台业务逻辑操作类测试
 * @author overlord
 *
 */
public class StockOutServiceTesting {

	static DBHandleDao<StockOut> service;
	static int id=-1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service=AppContextUtil.getServiceBean("stockoutService");
	}

	/**
	 * 测试StockOut从Service级到数据库的操作，存入新数据对象
	 */
	@Test
	public void test1() {
		StockOut stockout=new StockOut();
		stockout.setName("测试1");
		id=service.save(stockout);
		System.out.println("test1.id="+id);
	}
	
	/**
	 * 取出、修改，并更新数据对象
	 */
	@Test
	public void test2(){
		StockOut stockout=service.queryId(1);
		stockout.setName("测试修改2");
		service.update(stockout);
		System.out.println("test2.result="+service.queryId(stockout.getId()).getName());
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
		List<StockOut> li=service.queryAll();
		for(StockOut stockout:li){
			System.out.println("test3: id="+stockout.getId()+" name="+stockout.getName());
		}
	}

}
