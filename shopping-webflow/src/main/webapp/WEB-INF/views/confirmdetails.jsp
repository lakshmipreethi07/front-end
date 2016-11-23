<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>purchase confirm details</title>
		<link href="style.css" rel="stylesheet" type="text/css" />
	</head>
 
	<body>
		<div class="content">
			<fieldset>
				<legend>Confirm Details</legend>
				<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
				<a href="${flowExecutionUrl}&_eventId_home">Home</a><br /><br />
				<sf:form modelAttribute="cartdetails">
					<sf:label path="customerid">customerid:</sf:label>${cartdetails.customerid}
					<br /><br />
					<sf:label path="customeraddress">customer address:</sf:label>${cartdetails.customeraddress}
					<br /><br />
					<sf:label path="shippingaddress">shipping address :</sf:label>${cartdetails.shippingaddress}
					<br /><br />
					<sf:label path="quantity">quantity :</sf:label>${cartdetails.quantity}
					<br /><br />
					
					<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->
					<input name="_eventId_edit" type="submit" value="Edit" /> 
					<input name="_eventId_submit" type="submit" value="Confirm Details" /><br />
				</sf:form>
			</fieldset>
		</div>
	</body>
</html>