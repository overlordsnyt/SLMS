package com.slms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.slms.dao.DaoTest;
import com.slms.domain.ConnectionTest;
import com.slms.tools.AppContextUtil;
/**
 * 连通测试的Action
 * @author overlord
 *
 */
public class ConnectionTestAction extends ActionSupport {
	private static final long serialVersionUID = -1476670317548508410L;
	
	//创建一个封装的数据类型，通过struts页面的test.attr存取其属性
	private ConnectionTest test;
	public ConnectionTest getTest() {
		return test;
	}
	public void setTest(ConnectionTest test) {
		this.test = test;
	}
	
	/**
	 * Action提交操作，得到操作结果
	 * @return	result标识
	 */
	public String saveSubmit(){
		@SuppressWarnings("rawtypes")
		DaoTest handle=AppContextUtil.getHandleBean("connectiontest");
		@SuppressWarnings("unchecked")
		int result=handle.savetest(test);
		if(result==-1)return "error";
		return "success";
	}
}
