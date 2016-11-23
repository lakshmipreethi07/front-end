<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="adminhome.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
<style type="text/css">
table, td, th {
    border: 1px solid #ddd;
    text-align: left;
}

table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 15px;
}

</style>

</head>
<body>
<div class="container-fluid">
<div class="row">
<center>
<div class="col-sm-12">
  <div class="col-sm-3"></div><div class="col-sm-6">
  
			

	<c:url var="addAction" value="/addsupplier"></c:url>

	<form:form action="${addAction}" commandName="supplier">
		<table>
			<tr>
				<td><form:label path="id"  >
						<spring:message text="SUPPLIER ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty supplier.id}">
						<td><form:input path="id" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="id" pattern =".{3,7}" required="true" title="id should contains 3 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
			<form:input path="id"  hidden="true"  />
				<td><form:label path="name">
						<spring:message text="Supplier Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
						<spring:message text="Supplier Address" />
					</form:label></td>
						<td><form:input path="address" required="true" /></td>
				<td>
				
				<td colspan="2"><c:if test="${!empty supplier.name}">
						<input type="submit" 
							value="<spring:message text="Edit Supplier"/>" />
					</c:if> <c:if test="${empty supplier.name}">
						<input type="submit"  value="<spring:message text="Add Supplier"/>" />
					</c:if></td>
		</table>
	
	</form:form>
	
	</div>
	</div>
	</div>
	<div class="col-sm-3"></div>
	</div>
	
	<br>
	
	
	<c:if test="${!empty supplierList}">
		<table class="tg" style="align:center">
			<tr>
				<th>Supplier ID</th>
				<th>Supplier Name</th>
				<th>Supplier Address</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.address}</td>
					<td><a href="<c:url value='/editsupplier/${supplier.id}' />">Edit</a></td>
					<td><a href="<c:url value='/removesupplier/${supplier.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	</div>
	</div>
	</center>
	</div>
	</div>
	
</body>

</html>