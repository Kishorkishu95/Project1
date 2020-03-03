<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>customer form here</title>
<link rel="stylesheet" href = "${pageContext.request.contextPath}/resources/css/add-customer-style.css" type="text/css" />
<link rel="stylesheet" href = "${pageContext.request.contextPath}/resources/css/style.css" type="text/css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	<h3>Save Customer</h3>
	<form:form action="saveCustomer" method="post" modelAttribute="customer">
	
	<!-- Need to associate this data with customer id -->
	<form:hidden path="id" />
		<table>
		<tbody>
			<tr>
			<td><label>First Name </label></td>
			<td><form:input path="firstName"/></td>
			</tr>
			<tr>
			<td><label>Last Name </label></td>
			<td><form:input path="lastName"/></td>
			</tr>
			<tr>
			<td><label>Email </label></td>
			<td><form:input path="email"/></td>
			</tr>
			<tr>
			<td><label></label></td>
			<td><input type="submit" value="Save" class="save"/></td>
			</tr>
		</tbody>
		</table>
	</form:form>
	<div style="clear; both;"></div>
	<p><a href="${pageContext.request.contextPath}/customerController/list">Back</a></p>
	</div>


</body>
</html>