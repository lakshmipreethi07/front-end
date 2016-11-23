<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New or Edit User</title>
</head>
<body>
<c:url var="category" value="category/add" />
  <form:form id="category" modelAttribute="category" method="post"
   action="category/update">
   <table width="400px" height="150px">
    <tr>
     <td><form:label path="name">Name</form:label>
     </td>
     <td><form:input path="name" />
     </td>
    </tr>
    <tr>
     <td><form:label path="id">ID</form:label>
     </td>
     <td><form:input path="id" />
     </td>
    </tr>
    <tr>
     <td><form:label path="description">Description</form:label>
     </td>
     <td><form:input path="description" />
     </td>
    </tr>
    <tr>
     <td></td>
     <td><input type="submit" value="add" /></td>
    </tr>
   </table>
  </form:form>

	<h1>Category List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Description</th></th><th>Edit</th><th>Delete</th></tr>  
   <c:forEach var="category" items="${categoryList}">   
   <tr>  
   <td>${category.id}</td>  
   <td>${category.name}</td>  
   <td>${category.description}</td>  
   <td><a href="category/edit{id}">Edit</a></td>  
   <td><a href="category/remove{id}">Delete</a></td>  
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
</body>
</html>