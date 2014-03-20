<table width="100%">
	<tr>
		<td><h2><i>Online Polling System</i></h2></td>
		<td align="right">
			<%= (new java.util.Date()).toLocaleString() %>
		</td>
	</tr>

	<c:if test="${user != null}">
		<tr>
			<td>Welcome <b><c:out value="${user.firstName}"/></b>!&nbsp;			
				<font size=1>[<a href="logout.jsp">Logout</a>]</font>
			</td>
			<td>&nbsp;</td>
		</tr>
	</c:if>
</table>
<hr>
<p>

