<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@include file="/WEB-INF/views/header.jsp"%>




<div class="span9 center margin-bottom"> 
					<h3>Product Details</h3>
					</div>
        <div class="container" ng-app = "addToCartApp">
                <div class="row">
	 <div class="span3">
		<img src="<c:url value="D:/images/${product.name}.jpg"/>"/>
	</div>	 
	  
	<div class="span5">

		<div class="spanAddress">
			<address>
				<strong>Name:</strong> <span>${product.name}</span><br>
				<strong>Description:</strong> <span>${product.description}</span><br>
				<strong>Manufacturer:</strong> <span>${product.supplier}</span><br>
				<strong>Category:</strong> <span>${product.category}</span><br>
				
			</address>
		</div>	
				
		<div class="span6">
			<h2>
				<strong>Price: Rs. ${product.price}</strong> <br><br>
			</h2>
		</div>	
		
					
		
						<div class="span6">
							<div class="span4 no_margin_left">
									<p ng-controller="addToCartCtrl">
									
										<a href="#" class="btn btn-primary"
										   ng-click="addItemToCart('${product.id}')"><span
												class="glyphicon glyphicon-shopping-cart"></span>Add to cart
											</a>
										<a href="<spring:url value="/user/cart" />"
										   class="btn btn-primary"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
							
								</p>
							</div>	
							
			
						</div>	
		
						<div class="span6">
						
							
						</div>	
		
		 			</div>	

  				</div>


                    
                    
                </div>

        <script src="/js/ordercontroller.js"> </script>
        
        <%@include file="/WEB-INF/views/footer.jsp" %>
