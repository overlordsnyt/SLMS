# 简化进销存管理系统

## 简介

学校期末实训项目

已初步完成项目的设计。
项目框架基本搭建完成，通过前端到后台逻辑到数据库更新的连通性测试。

## 开发环境

- 浏览器：Chrome 52 dev-m
- JavaJDK：jre1.8.0_91
- Web服务器：Tomcat v6.0
- 开发框架：struts2.3.1.2 、spring4.0.2 、hibernate4.1.1
- IDE:eclipse EE Luna 4.4.2
- 数据库：MySQL5.7.11

## 功能目标
1. 档案管理：员工档案、商品档案、客户档案
	- 按id、名称、id+名称或查询所有的方式查询符号条件的实体类数据。
	- 修改、删除查询结果中的条目。
	- 新增一条数据条目到数据库中。
2. 订单管理：进货单、订货单（出货单）
	- 按id、名称，或是AJAX获取的员工、商品、客户条目查询符合条件的实体类数据。
	- 修改、删除查询结果中的条目。
	- 新增一条数据条目到数据库中。

## 源文件说明

### doc/	开发文档
……

### sample/	资源模板
……

### WebContent/	前端页面

##### WEB-INF/

1. web.xml 基础Web配置

2. lib/	引入的框架jar包

##### test/
测试用页面

##### common/
页面共通的Frame结构和菜单等

### src/	后台处理

applicationContext.xml	Spring配置文件

struts.xml	Struts配置文件

##### configxml/	具体配置

1. applicationContext.xml的具体配置
	1. dbconnection.xml ：数据库连接dataSource、数据库连接工厂sessionFactory
	2. spring.xml ：事务管理transactionManager、切面配置aop:config、事务开启关闭的方法配置tx:advice
	3. bean.xml ：后台逻辑操作实例化类配置+Action控制器配置
2. struts.xml的具体配置
	1. label_zh_CN.properties ：国际化资源文件-中文
	2. action.xml ：页面提交至后台Action配置

##### com.slms.action	struts提交到的Action具体控制器

1. ConnectionTestAction.java 连通测试Action后台处理类


##### com.slms.dao	业务逻辑操作的Dao接口
1. ConnectionTestImpl.java	连通测试数据库操作实现类
2. DaoTest.java	连通测试数据库操作接口
3. DBConnection.java	由Spring创建SessionFactory的公共注入操作的父类
4. DBHandleDao.java	后台操作数据库的接口

##### com.slms.service	业务逻辑后台数据库操作的实现类
1. ClientService.java	客户档案的后台数据库操作实现类
2. GoodsService.java	商品档案的后台数据库操作实现类
3. StaffService.java	员工档案的后台数据库操作实现类
4. StockInService.java	进货单的后台数据库操作实现类
5. StockOutService.java	订货单的后台数据库操作实现类


##### com.slms.domain	关系实体及其hibernate数据库映射文件
1. ConnectionTest.hbm.xml	连通性测试实体映射配置
2. ConnectionTest.java	连通性测试实体
3. Client.hbm.xml、Client.java	客户档案实体类及其orm映射
4. Goods.hbm.xml、Goods.java	商品档案实体类及其orm映射
5. Staff.hbm.xml、Staff.java	员工档案实体类及其orm映射
6. StockIn.hbm.xml、StockIn.java	进货单实体类及其orm映射
7. StockOut.hbm.xml、StockOut.java	订货单实体类及其orm映射


##### com.slms.tools	共用工具类
1. AppContextUtil.java	一键创建ApplicationContext


##### test	边开发边测试的JUnit测试类
1. ConnectionTesting.java	连通性后台操作测试
2. ClientServiceTesting.java	客户档案的后台操作测试类
3. GoodsServiceTesting.java	商品档案的后台操作测试类
4. StaffServiceTesting.java	员工档案的后台操作测试类
5. StockInServiceTesting.java	进货单的后台操作测试类
6. StockOutServiceTesting.java	订货单的后台操作测试类

## 开发日志
2016-05-19
后台操作业务类→数据库操作及关系表数据实体 创建及测试完成

2016-05-16
数据字典的详细设计
项目启动初始化完成

2016-05-14
完成 前端→Struts的Action→Spring的实现Dao接口的Bean后台数据库操作类实例→数据库更新条目成功 的连通性测试