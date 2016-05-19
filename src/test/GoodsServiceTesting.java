package test;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.slms.dao.DBHandleDao;
import com.slms.domain.Goods;
import com.slms.tools.AppContextUtil;

/**
 * GoodsService的后台业务逻辑操作类测试
 * @author overlord
 *
 */
public class GoodsServiceTesting {

	static DBHandleDao<Goods> service;
	static int id=-1;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		service=AppContextUtil.getServiceBean("goodsService");
	}

	/**
	 * 测试Goods从Service级到数据库的操作，存入新数据对象
	 */
	@Test
	public void test1() {
		Goods goods=new Goods();
		goods.setName("测试1");
		id=service.save(goods);
		System.out.println("test1.id="+id);
	}
	
	/**
	 * 取出、修改，并更新数据对象
	 */
	@Test
	public void test2(){
		Goods goods=service.queryId(1);
		goods.setName("测试修改2");
		service.update(goods);
		System.out.println("test2.result="+service.queryId(goods.getId()).getName());
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
		List<Goods> li=service.queryAll();
		for(Goods goods:li){
			System.out.println("test3: id="+goods.getId()+" name="+goods.getName());
		}
	}

}
