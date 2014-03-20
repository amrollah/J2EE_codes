<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.*"%>
<%@page import="source.entity.auction"%>

<html>
<head>
<base href="<%=basePath%>">

<title>user page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
<h3>List of enabled Auction</h3>
<p>
<table border=1 cellpadding=5>
	<c:forEach var="ac" items="${auctions}">
		<tr>
			<td><c:url var="viewUrl" value="bid-form.jsp">
				<c:param name="id" value="${ac.getId()}" />
			</c:url> <a href="${viewUrl}">${ac.getSubject()}</a></td>
			<td><c:out value="${ac.getFinish_date()}" /></td>
		</tr>
	</c:forEach>
</table>
<p>
</body>
</html>
