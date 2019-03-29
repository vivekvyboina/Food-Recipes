<%@page import="model.RequestDB"%>
<%@page import="basics.RequestAction"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="pendingRequest" method="post">
		<table border="1">
				<tr>
					<td>REQUESTId</td>
					<td>EMPLOYEE ID</td>
					<td>SHORT ID</td>
					<td>MANAGER ID</td>
					<td>AssetName</td>
					<td>REQUESTDATE</td>
					<td>Status</td>	
					<td>Approve</td>
					
						
				</tr>
	
		 	
		 	<s:iterator value = "list" var = "user"  >
		 	<tr>
		 	<td><s:property value="requestid"/></td>
			<td><s:property value="employeeid"/></td>
			<td><s:property value="shortid"/></td>
			<td><s:property value="managerid"/></td>
			<td><s:property value="assetname"/></td>
			<td><s:property value="requestDate"/></td>
			<td><s:property value="status"/></td>
			<td><a href='Approve?requestid=<s:property value="requestid"/>'>Approve</a>/
			<a href='Reject?requestid=<s:property value="requestid"/>'>Reject</a></td>
			</tr>
			</s:iterator>
	</table>
	
	</form>
</body>
</html>