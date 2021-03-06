<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Kart Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
	<h1>
		Add a Kart
	</h1>

	<c:url var="addAction" value="/kart/add" ></c:url>

	<form:form action="${addAction}" commandName="kart">
	<table>
		<c:if test="${kart.id != 0}">
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
				<form:label path="userId">
					<spring:message text="User Name"/>
				</form:label>
			</td>
			<td>
				<form:select class="form-control" path="userId" required="true">
					<c:forEach items="${userList}" var="user">
						<form:option class="form-control" value="${user.id}">${user.firstName}	     </form:option>
					</c:forEach>
				</form:select>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<c:if test="${kart.id != 0}">
					<input type="submit"
						value="<spring:message text="Edit Kart"/>" />
				</c:if>
				<c:if test="${kart.id == 0}">
					<input type="submit"
						value="<spring:message text="Add Kart"/>" />
				</c:if>
			</td>
		</tr>
	</table>	
	</form:form>
	<br>
	<h3>Karts List</h3>
	<c:if test="${!empty listKarts}">
		<table class="tg">
		<tr>
			<th width="80">Kart ID</th>
			<th width="80">User ID</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listKarts}" var="kart">
			<tr>
				<td>${kart.id}</td>
				<td>${kart.userId}</td>
				<td><a href="<c:url value='/editKart/${kart.id}' />" >Edit</a></td>
				<td><a href="<c:url value='/removeKart/${kart.id}' />" >Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</body>
</html>