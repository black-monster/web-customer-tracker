<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<title>List Customers</title>
</head>

<body>
	<div id="wrapper">
		<div id="header">
		<h2>CRM-Cutomer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	<div id="context">
	<!-- add output html table -->
	
		<table>
			<tr>
			 <th>First Name</th>
			 <th>Last Name</th>
			 <th>Email</th>
			</tr>
			
			<c:forEach var="tempCustomer" items="${customers}">
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
</body>
</html>