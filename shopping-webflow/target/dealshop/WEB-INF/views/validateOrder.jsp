<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />



              <form:form commandName="order" class="form-horizaontal">
              <div class="span9 margin-top">
                   <div class="span9 center margin-bottom"> 
					<h3>Order Details</h3>
					</div>
						<div class="span4">

                               
                            <div class="col-xs-12 col-sm-12 col-md-12 ">
                                <p>Shipping Date: <fmt:formatDate type="date" value="${now}"/></p>
                            </div>
                        </div>

                        
                      
                        <div class="row margin-left25" ng-controller = "cartCtrl" ng-init="initCartId('${cartId}')">
								<table class="table table-bordered table-striped fs13">
								  <thead>
									  <tr>
										
										<th >Image</th>
										<th class="width110">Product Name</th>
										<th class="width110">Unit Price</th>
										<th>Quantity</th>
										<th>Price(in Rs.)</th>
										
									  </tr>
									</thead>
									<tbody>
                                <c:forEach var="cartItem" items="${order.cart.cartItems}" >
                                    <tr>
                                   <%--  <td class="span1"><img src="<c:url value="/resources/images/${cartItem.item.itemId}.png" /> " alt="image"/></td> --%>
                                        <td class="col-md-9"><em>${cartItem.pname}</em></td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.quantity}</td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.price}</td>
                                        <td class="col-md-1" style="text-align: center">${cartItem.totalPrice}</td>
                                    </tr>
                                </c:forEach>

                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td class="text-right">
                                        <h4><strong>Grand Total(in Rs.) </strong></h4>
                                    </td>
                                    <td class="text-center text-danger">
                                        <h4><strong>${order.cart.grandTotal}</strong></h4>
                                    </td>
				<td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        
                        <div class="span3 center">
					 	 <button class="btn btn-primary" name="_eventId_backToShippingAddProcess">Back</button>
					    </div>
					  <div class="span3 center ">
					  <input type="hidden" name="_flowExecutionKey" />
						<input type="submit" value="Submit Order" class="btn btn-primary"
                               name="_eventId_validateOrderProcessCompleted"/>
						 </div>
						 <div class="span2 center ">
					 	<button class="btn btn-danger" name="_eventId_cancel">Cancel</button>
					    </div>
                        
                    </div>
                </form:form>

           

