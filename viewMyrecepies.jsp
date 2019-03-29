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
	<form action="delete" method="post">
		<table border="1">
				<tr>
					<td>RECEIPEID</td>
					<td>USERID</td>
					<td>DISH NAME</td>
					<td>INGREDIENTS</td>
					<td>PROCEDURE</td>
					<td>Delete</td>
					
						
				</tr>
	
		 	
		 	<s:iterator value = "list" var = "user"  >
		 	<tr>
		 	<td><s:property value="receipeid"/></td>
			<td><s:property value="userid"/></td>
			<td><s:property value="recipeName"/></td>
			<td><s:property value="ingredients"/></td>
			<td><s:property value="procedure"/></td>
			<td>
			<a href='Remove?requestid=<s:property value="receipeid"/>'>Remove</a></td>
			</tr>
			</s:iterator>
	</table>
	
	</form>
</body>
</html>