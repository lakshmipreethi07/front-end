<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html lang="en">
<%@include file="header.jsp" %>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>

</head>
<body style="background-color:hsla(290,60%,70%,0.3)">
	

<%--   <script src="<c:url value="ordercontroller.js" /> "></script> --%>
<div ng-app = "addToCartApp" ng-controller="addToCartCtrl"> 
	
			<div class="container-fluid text-center bg-grey" >
			
			 <div class="row text-center">
			 <p >
<c:forEach items="${productList}" var="product">
				<div class="col-sm-4">
					<div class="thumbnail">
						<img src="D:\images/${product.name}.jpg" class="img-responsive" style="height:200px; width:60%"/>
						<div class="caption">
							<h4 class="pull-right">${product.price}</h4>
							<p>${product.name }</p>
							
									<button class="btn btn-primary"
										   ng-click="addItemToCart('${product.id}')"><span
												class="glyphicon glyphicon-shopping-cart"></span>Add to cart
											</button>
							
						</div>
						<div class="ratings">
							<p class="pull-right">15 reviews</p>
							<p>
								<span class="glyphicon glyphicon-star"></span>
								 <span class="glyphicon glyphicon-star"></span>
								  <span	class="glyphicon glyphicon-star"></span>
								   <span class="glyphicon glyphicon-star"></span>
									 <span class="glyphicon glyphicon-star"></span>
							</p>
						</div>
					</div>
				</div>
</c:forEach>
</p>
		</div>
		</div>		
</div>
 <script>
 /*
  * This controller is used to handle rest calls related to cart page. This controller is mapped with CartManagementController to call related rest service.
  */

 var cartApp = angular.module ("addToCartApp", []);

 cartApp.controller("addToCartCtrl", function ($scope, $http){
 	
 	 /*
      * retrieveCart method is used to get all cart items at the starting of the application
      */
     $scope.retrieveCart = function (cartId) {
         $scope.cartId = cartId;
         $scope.refreshCartItems(cartId);
     };
     
     
     /*
      * removeItemFromCart method is used to remove a item from the cart
      */
     $scope.removeItemFromCart = function (id) {
         $http.put('http://localhost:8080/sampleweb/usercart/cart/removeItem/'+id).success(function (data) {
             $scope.refreshCartItems();
         });
     };

 	 /*
      * addItemToCart method is used to add items into the cart
      */
     $scope.addItemToCart = function (id) {
         $http.put('http://localhost:8080/sampleweb/usercart/cart/addItem/'+id).success(function (data) {
             alert("Item added to the cart!")
             
         });
     };
    
    
     /*
      * GrandTotalOfItems method is called on cart page to calculate grand total for the added items
      */
     $scope.GrandTotalOfItems = function () {
         var grandTotal=0;

         for (var i=0; i<$scope.cart.cartItems.length; i++) {
             grandTotal+=$scope.cart.cartItems[i].totalPrice;
        }

         return grandTotal;
     };
     /*
 	 * refreshCartItems method is called by others methods in same controller to refresh the cart
 	 */
     $scope.refreshCartItems = function () {
         $http.get('http://localhost:8080/sampleweb/usercart/cart/refreshCart/'+$scope.cartId).success(function (data) {
            $scope.cart=data;
         });
     };
     
     /*
      * clearCartItems method is used to delete all items from the cart
      */
     $scope.clearCartItems = function () {
     	$http['delete']('http://localhost:8080/sampleweb/usercart/cart/clearCartItems/'+$scope.cartId).success(function (data)
     			{$scope.refreshCartItems()
     		});
     };
 });



</script>
 







</body>
</html>