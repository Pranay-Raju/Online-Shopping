<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Product Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
	<h1>
		Add a Product
	</h1>

	<c:url var="addAction" value="/product/add" ></c:url>

	<form:form action="${addAction}" commandName="product">
	<table>
		<c:if test="${product.id != 0}">
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
			<td><label for="Product Category">Product Category</label></td>
			<td>
			<form:select class="form-control" path="categoryId" required="true">
				<c:forEach items="${categoryList}" var="category">
					<form:option class="form-control" value="${category.id}">${category.name}	     </form:option>
				</c:forEach>
			</form:select>
			</td>
		</tr>
		
		<tr>
			<td>
				<label for="Product Supplier">Product Supplier</label>
			</td>		
			<td>
				<form:select class="form-control" path="supplierId" required="true">
					<c:forEach items="${supplierList}" var="supplier">
						<form:option class="form-control" value="${supplier.id}">${supplier.name}	     </form:option>
					</c:forEach>
				</form:select>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<c:if test="${product.id != 0}">
					<input type="submit"
						value="<spring:message text="Edit Product"/>" />
				</c:if>
				<c:if test="${product.id == 0}">
					<input type="submit"
						value="<spring:message text="Add Product"/>" />
				</c:if>
			</td>
		</tr>
	</table>	
	</form:form>
	<br>
	<h3>Products List</h3>
	<c:if test="${!empty listProducts}">
		<table class="tg">
		<tr>
			<th width="80">Product ID</th>
			<th width="120">Product Name</th>
			<th width="120">Product Category</th>
			<th width="120">Product Supplier</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listProducts}" var="product">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<c:forEach items="${categoryList}" var="category">
					<c:if test="${product.categoryId == category.id }">
						<td>${category.name}</td>
					</c:if>
				</c:forEach>
				<c:forEach items="${supplierList}" var="supplier">
					<c:if test="${product.supplierId == supplier.id }">
						<td>${supplier.name}</td>
					</c:if>
				</c:forEach>
				<td><a href="<c:url value='/editProduct/${product.id}' />" >Edit</a></td>
				<td><a href="<c:url value='/removeProduct/${product.id}' />" >Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</body>
</html>