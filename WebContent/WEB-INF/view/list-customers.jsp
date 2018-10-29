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
	
	<!-- put new button : Add Customer -->
	<input type="button" value="Add Cutomer" onclick="window.location.href='showFormForAdd'";return false; class='add-button'/>
	<!-- add output html table -->
	
		<table>
			<tr>
			 <th>First Name</th>
			 <th>Last Name</th>
			 <th>Email</th>
			 <th>Action</th>
			</tr>
			
			<c:forEach var="tempCustomer" items="${customers}">
				
				<!-- Construct an "update" link with customer id -->
				
				<c:url var="updatelink" value="showFormForUpdate">
					<c:param name="customerId" value="${tempCustomer.id}"/>
				</c:url>
				
				<!-- Construct a "delete" link with customer id -->
				
				<c:url var="deletelink" value="delete">
					<c:param name="customerId" value="${tempCustomer.id}"/>
				</c:url>
				<tr>
					<td>${tempCustomer.firstName}</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email}</td>
					<td><a href="${updatelink}">Update</a> | 
					<a href="${deletelink}" onclick="if(!(confirm('Are you sure you want to delete this customer ?'))) return false">Delete</a>
				</tr>
			</c:forEach>
		</table>
		</div>
	</div>
</body>
</html>