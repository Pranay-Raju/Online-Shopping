<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Supplier Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Supplier
</h1>

<c:url var="addAction" value="/supplier/add" ></c:url>

<form:form action="${addAction}" commandName="supplier">
<table>
	<c:if test="${!empty supplier.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="number">
				<spring:message text="number"/>
			</form:label>
		</td>
		<td>
			<form:input path="number" />
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${supplier.id != 0}">
				<input type="submit"
					value="<spring:message text="Edit Supplier"/>" />
			</c:if>
			<c:if test="${supplier.id == 0}">
				<input type="submit"
					value="<spring:message text="Add Supplier"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Suppliers List</h3>
<c:if test="${!empty listSuppliers}">
	<table class="tg">
	<tr>
		<th width="80">Supplier ID</th>
		<th width="120">Supplier Name</th>
		<th width="120">Supplier Phone Number</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listSuppliers}" var="supplier">
		<tr>
			<td>${supplier.id}</td>
			<td>${supplier.name}</td>
			<td>${supplier.number}</td>
			<td><a href="<c:url value='/editSupplier/${supplier.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/removeSupplier/${supplier.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>