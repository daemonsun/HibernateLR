<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="action.Register" %>
<jsp:useBean id="obj" class="po.Student"></jsp:useBean>
<jsp:setProperty property="*" name="obj" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'registerResult.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  	<%
	    switch(Register.register(obj)){
	    	case 1:
	    		out.println("已存在的账号");
	    		break;
	    	case 2:
	    		out.println("注册成功");
	    		break;
	    	case 3:
	    		out.println("存在未填信息");
	    		break;
	    }
	%>
    <a href="login.jsp">返回登录页</a>
  </body>
</html>
