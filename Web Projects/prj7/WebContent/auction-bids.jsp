<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>auction bids</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<p>
<table border=1 cellpadding=5>
	<tr>
		<td>Bider Name</td>
		<td>Bid Value</td>
	</tr>
	<c:forEach var="bid" items="${bids}">
		<tr>
			<td>${bid.getUser().getName()}</td>
			<td>${bid.getBid()}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>
