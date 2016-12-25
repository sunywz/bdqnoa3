<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>文档管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<frameset rows="*" cols="187,*" framespacing="1" frameborder="yes" border="1">
  <frame src="forwardAction_left.action"  scrolling="yes"/>
  <frame src="accessory_findAcfByid.action" name="right" scrolling="yes" id="right"/>
</frameset>

<noframes>
<body>
</body>
</noframes>
</html>
