<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>New Bid</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
	function Validate2() {
		var frm = document.bidForm;

		if (frm.name.value == "" || frm.code.value == "" || frm.bid.value == "") {
			alert("All fields are required.");
			return false;
		}
		return true;
	}

	// Ajax content
	function getXMLObject() //XML OBJECT
	{
		var xmlHttp = false;
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP"); // For Old Microsoft Browsers
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP"); // For Microsoft IE 6.0+
			} catch (e2) {
				xmlHttp = false; // No Browser accepts the XMLHTTP Object then false
			}
		}
		if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
			xmlHttp = new XMLHttpRequest(); //For Mozilla, Opera Browsers
		}
		return xmlHttp; // Mandatory Statement returning the ajax object created
	}

	var xmlhttp = new getXMLObject(); //xmlhttp holds the ajax object

	function ajaxFunction() {
		if (xmlhttp) {
			var bid = document.getElementById("bid");
			var jString = "?bid=" + bid.value + "&id="
					+
<%=request.getParameter("id")%>
	;
			xmlhttp.open("GET", "ajax.jsp" + jString, true); //getname will be the servlet name
			xmlhttp.onreadystatechange = handleServerResponse;
			xmlhttp.send(); //Posting txtname to Servlet
		}
	}

	function handleServerResponse() {
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.status == 200) {
				var res = xmlhttp.responseText + "";
				if (res.indexOf("True", 0) > 0) {
					document.bidForm.submit();
				} else {
					alert("Please Enter a Bid Greater");
				}
			}

		}
	}
</script>
</head>

<body>
<h3>New Bid Information:</h3>
<p>
<form action="saveBidCtrl" method="POST" name="bidForm"><input
	type="hidden" name="code" size=20 value=<%=request.getParameter("id")%> />
Bid:<br>
<input type="text" name="bid" id="bid" size=20 />
<p><input type="button" value="Save" onclick="ajaxFunction();" />
</form>
</body>
</html>
