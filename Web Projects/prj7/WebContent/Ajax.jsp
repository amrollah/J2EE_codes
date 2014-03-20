<%@page import="source.DAO.auctionDAO"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@page import="source.entity.auction,source.entity.bid"%>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Ajax.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%
	auctionDAO ad = new auctionDAO();
	auction ac = ad.findByCode(new Integer((request
			.getParameter("id"))));
			response.getWriter().print("123 ");
	if (Integer.parseInt(request.getParameter("bid")) >= ac
			.getBase_price()) {
		response.getWriter().print("True");
	} else {
		response.getWriter().print("False");
	}
%>

</html>
