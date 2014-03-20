<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<base href="<%=basePath%>">

<title>result page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
The winner of this auction is
<c:choose>
	<c:when test="${winner} == null">
	
	nobody!
	
	</c:when>
	<c:otherwise>
	
	${winner.getUser().getName()}
	<br>
	with  
	${winner.getBid()}
	</c:otherwise>
</c:choose>
<br>
</body>
</html>
