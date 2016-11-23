<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="header.jsp"%>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
form {
    border: 0.5px solid #f1f1f1;
}

input[type=text], input[type=password] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 0.5px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 14px 0 8px 0;
    max-width:100%;
max-height:100%;
}

img.avatar {
    width: 20%;
    border-radius: 10%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
<body background="/resources/back.jsp">
${msg}
<script type="text/javascript">
function validate() {
	if (document.form1.name.value == "") {
		alert("enter your user name");
		return false;
	}
	if (document.form1.password.value == "") {
		alert("Enter the password");
		return false;
	}

	else {
		alert("Login successfully");
		return true;
	}
}

</script>
	<form:form class="form-horizontal" method="post" name="form1" onsubmit="return validate()" action="perform_login">
<h2>Login Form</h2>
  <div class="imgcontainer">
    <img src=<c:url value="/resources/create_thumb.png"/> alt="Avatar" class="avatar">
  </div>

  <div class="container">
  <div class="col-xs-6">
    <label><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="username" required>

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" required>
        
    <button type="submit">Login</button>
    <input type="checkbox" checked="checked"> Remember me
    <span class="psw">Forgot <a href="#">password?</a></span>
  </div>

  </div>
</form:form>

</body>
</html>
<%@include file="footer1.jsp" %>

