<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body
	background="E:\programs\ShoppingCartFrontEnd\src\main\webapp\images\reg.jpg">

	<script type="text/javascript">
		function a() {

			
				 

				if(document.form1.mobile.value=="")
					{
					alert("enter your mobile number");
					return false;
					}
				 if (document.form1.mobile.value.length<10 || document.form1.mobile.value.length>10) {
					alert("The mobile number must contains only 10 digits");
					return false;
				 }
				 if(!(document.form1.mobile.value.charAt(0)=="9"))
				 {
				 alert("mobile no should start with 9")
				 return false;
				 }
			 else
				 {
				 alert("successfully registered");
				 return true;
				 }
			

			}


				
	</script>
	<center><p>Register here</p>
	</center>
		<div class="container">
		
		<!-- class="form-horizontal" role="form"  class="form" commandName="userDetails" name="form1" onsubmit="return a()" -->
		<c:url var="addAction" value="/RegisterSuccess">
		</c:url>
		<form:form method="post" action="${addAction}" commandName="Userdetails" class="form-horizontal" onsubmit="return a()" name="form1">  
  <div class="form-group">
    <label class="control-label col-xs-4"><spring:message text="NAME:"/></label>
    <div class="col-xs-4"> 
      <input type="text" class="form-control" name="username" required="true"/>
    </div>
  </div><br>
  
  <div class="form-group">
  <label class="control-label col-xs-4"><spring:message text="YOUR NAME:"/></label>
    <div class="col-xs-4"> 
      <input type="text" class="form-control" name="yourname" required="true"/>
    </div>
  </div><br>
  <div class="form-group">
    <label class="control-label col-xs-4"><spring:message text="EMAIL:"/></label>
    <div class="col-xs-4"> 
      <input type="email" class="form-control" name="email" required="true" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" title ="enter a valid email id"/>
    </div>
  </div><br>
  <div class="form-group">
    <label  class="control-label col-xs-4"><spring:message text="MOBILE NO:"/></label>
    <div class="col-xs-4"> 
      <input type="number" class="form-control" name="mobile" required="true"   title="Please enter valid mobile number">
    </div>
  </div><br>
  <div class="form-group">
    <label class="control-label col-xs-4"><spring:message text="PASSWORD:"/></label>
    <div class="col-xs-4"> 
      <input type="password" class="form-control" name="password" pattern=".{6,8}" required="true" title="password should contain 6 to 8 characters">
    </div>
  </div>
  <div class="form-group">
    <label class="control-label col-xs-4"><spring:message text="ADDRESS:"/></label>
    <div class="col-xs-4"> 
      <input type="text" class="form-control" name="address" required="true">
    </div>
  </div>
   					 
  
  <br>
  	<center><button type="submit" class="btn btn-success">SUBMIT</button></center>
  </form:form>
		
	</div>
</body>

<%@ include file="footer1.jsp" %>
</html>
				

			
		
