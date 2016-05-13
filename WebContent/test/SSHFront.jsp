<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页面</title>
</head>
<body>
<h2>测试：页面struts→输入通过Action传入实体→调用dao的实现类操作数据库→数据库数据更新</h2>
<s:form action="ConnectionTest" method="post">
	<s:textfield key="username" name="test.username"></s:textfield>
	<s:password key="password" name="test.password"></s:password>
	<s:submit key="submit"></s:submit>
</s:form>
</body>
</html>