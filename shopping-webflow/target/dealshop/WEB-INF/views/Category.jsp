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
  
			

	<c:url var="addAction" value="/addcategory"></c:url>

	<form:form action="${addAction}" commandName="category">
		<table>
			<tr>
				<td><form:label path="id"  >
						<spring:message text="Category ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty category.id}">
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
						<spring:message text="Category Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="description">
						<spring:message text="Category Description" />
					</form:label></td>
					<td><form:input path="description" required="true" /></td>
					</tr>
				
				
				<td colspan="2"><c:if test="${!empty category.name}">
						<input type="submit" 
							value="<spring:message text="Edit Category"/>" />
					</c:if> <c:if test="${empty category.name}">
						<input type="submit"  value="<spring:message text="Add Category"/>" />
					</c:if></td>
		</table>
	
	</form:form>
	
	</div>
	</div>
	</div>
	<div class="col-sm-3"></div>
	</div>
	
	<br>
	
	
	<c:if test="${!empty categoryList}">
		<table class="tg" style="align:center">
			<tr>
				<th>Category ID</th>
				<th>Category Name</th>
				<th>Category Description</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value='/editcategory/${category.id}' />">Edit</a></td>
					<td><a href="<c:url value='/removecategory/${category.id}' />">Delete</a></td>
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