<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>KartList Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
	<h1>
		Add a KartList
	</h1>

	<c:url var="addAction" value="/kartItem/add" ></c:url>

	<form:form action="${addAction}" commandName="kartItem">
	<table>
		<c:if test="${kartItem.id != 0}">
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
				<form:label path="kartId">
					<spring:message text="Kart Id"/>
				</form:label>
			</td>
			<td>
				<form:select class="form-control" path="kartId" required="true">
					<c:forEach items="${karts}" var="kart">
						<form:option class="form-control" value="${kart.id}">${kart.userId}	     </form:option>
					</c:forEach>
				</form:select>
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="productId">
					<spring:message text="Product"/>
				</form:label>
			</td>
			<td>
				<form:select class="form-control" path="productId" required="true">
					<c:forEach items="${productList}" var="product">
						<form:option class="form-control" value="${product.id}">${product.name}	     </form:option>
					</c:forEach>
				</form:select>
			</td>
		</tr>
		
		<tr>
			<td>
				<form:label path="quantity">
					<spring:message text="Quantity"/>
				</form:label>
			</td>
			<td>
				<form:select class="form-control" path="quantity" required="true">
					<form:option class="form-control" value="1">1	     </form:option>
					<form:option class="form-control" value="2">2	     </form:option>
					<form:option class="form-control" value="3">3	     </form:option>
					<form:option class="form-control" value="4">4	     </form:option>
				</form:select>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<c:if test="${kartItem.id != 0}">
					<input type="submit"
						value="<spring:message text="Edit KartList"/>" />
				</c:if>
				<c:if test="${kartItem.id == 0}">
					<input type="submit"
						value="<spring:message text="Add KartList"/>" />
				</c:if>
			</td>
		</tr>
	</table>	
	</form:form>
	<br>
	<h3>KartLists List</h3>
	<c:if test="${!empty listKartItems}">
		<table class="tg">
		<tr>
			<th width="80">KartList ID</th>
			<th width="80">User ID</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listKartItems}" var="kartItem">
			<tr>
				<td>${kartItem.id}</td>
				<td>${kartItem.productId}</td>
				<td><a href="<c:url value='/editKartList/${kartItem.id}' />" >Edit</a></td>
				<td><a href="<c:url value='/removeKartList/${kartItem.id}' />" >Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty listKartItems}">
	<table class="tg">
		<tr>
			<th width="80">KartList ID</th>
			<th width="80">User ID</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<tr>
			<td>NoItems</td>
		</tr>
		</table>
	</c:if> 
</body>
</html>