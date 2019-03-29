<%@page import="model.RequestDB"%>
<%@page import="basics.RequestAction"%>
<%@page import="java.util.List"%>
<%@page import="model.Authenticator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<<%
session.invalidate();
response.sendRedirect("home.html");
%>
</body>
</html>