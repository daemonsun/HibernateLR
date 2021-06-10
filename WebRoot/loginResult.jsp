<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="action.Login" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'loginDo.jsp' starting page</title>
    
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
	    String acc = request.getParameter("account");
	    String pwd = request.getParameter("password");
	    if(Login.login(acc, pwd) == true){
	    	out.println("登录成功");
	    }else{
	    	out.println("登录失败");
	    }
  	%>
  </body>
</html>
