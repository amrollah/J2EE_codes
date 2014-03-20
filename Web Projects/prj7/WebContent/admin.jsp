<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<base href="<%=basePath%>">

<title>admin page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="jquery-1.7.2.js"></script>

<script type="text/javascript">
	function closeAuction(code, finish) {
	
	var parts = finish.split("/");
	var acDate = parts[2] + parts[1] + parts[0];
    var date = new Date();
    var day = date.getUTCDate();
    if (date.getUTCDate()<10)
    	day = "0" + date.getUTCDate();
    var month;
    if (date.getMonth()<10)
    	month = "0" + date.getMonth();
    var today = date.getFullYear() + "" + month + "" + day;

	var eval = +acDate - +today;
	if (eval < 0){
		window.location.href = "close.jsp?id=" + code;
		}
	else {if (confirm("Are you sure you want to close this auction?")) 	
			window.location.href = "close.jsp?id=" + code;
		
		}
	}
</script>
</head>

<body>
<h3>List of Auction</h3>
<p>
<table border=1 cellpadding=5>
	<c:forEach var="ac" items="${auctions}">
		<tr>
			<td><c:out value="${ac.getId()}" /></td>
			<td><a href="auction-bids.jsp?id=${ac.getId()}"><c:out
				value="${ac.getSubject()}" /></a></td>
			<td><c:out value="${ac.getFinish_date()}" /></td>
			<td><c:url var="viewUrl" value="auction-bids.jsp">
				<c:param name="id" value="${ac.getId()}" />
			</c:url> <a href="${viewUrl}">View Bids</a></td>
		</tr>

		<c:if test="${ac.isIs_enabled()}">
			<td><input type="button" value="Close auction"
				onclick="javascript: closeAuction(${ac.getId()},'${ac.getFinish_date()}');" /></td>
		</c:if>
		<c:if test="${ac.listbids().size() == 0}">
			<td><c:url var="delUrl" value="deleteAuctionCtrl">
				<c:param name="id" value="${ac.getId()}" />
			</c:url>
			<a href="${delUrl}">delete</a></td>
		</c:if>
	</c:forEach>
</table>
<p><a href="newAuction.action">New Auction</a>
</body>
</html>
