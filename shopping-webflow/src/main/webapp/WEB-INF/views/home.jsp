<!DOCTYPE html>
<html lang="en">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <%@include file="header.jsp" %>
<head>
  <title>Shop 360Degree</title>
  <meta charset="utf-8">
 
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!...............carosel.........................>
<style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
      background-size:cover;
       background-repeat: no-repeat;
  }
  body{
  backgroun-color:lightyellow;}
  </style>
</head>
<body>

</nav>
  <div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>
<!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">

      <div class="item active">
        <img src=<c:url value="/resources/Appple2.jpg"/> class="img-responsive">
        <div class="carousel-caption">
          <h3>Laptops</h3>
          <p>ALL Brands at best prices .</p>
        </div>
      </div>

    <div class="item">
         <img src=<c:url value="/resources/watch.jpg"/> class="img-responsive">
        <div class="carousel-caption">
          <h3>Watches</h3>
          <p>30-50% off best brands.</p>
        </div>
      </div>
    
      <div class="item">
         <img src=<c:url value="/resources/st.jpg"/> class="img-responsive">
        <div class="carousel-caption">
          <h3>Stationery</h3>
          <p>special offer for classmates notebooks</p>
        </div>
      </div>

      <div class="item">
         <img src=<c:url value="/resources/lap.jpg"/> class="img-responsive">
        <div class="carousel-caption">
          <h3>i phones</h3>
          <p>Discount is only for short time .shop now</p>
        </div>
      </div>
  
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>
<div class = "row">
   
   <div class = "col-sm-6 col-md-3">
      <div class = "thumbnail">
         <img src = "resources/sch.jpg" alt = "Generic placeholder thumbnail">
      </div>
      
      <div class = "caption">
         <h3>Rs.1000</h3>
         <p>school bags</p>
         
         <p>
            <a href = "LoginHere" class = "btn btn-primary" role = "button">
               Add to Cart
            </a> 
            
            
         </p>
         
      </div>
   </div>
   
   <div class = "col-sm-6 col-md-3">
      <div class = "thumbnail">
         <img src = "resources/ONEINDIANGIRLjpg.jpg" alt = "Generic placeholder thumbnail">
      </div>
      
      <div class = "caption">
         <h3>Rs.500</h3>
         <p>Books with 25%off</p>
         
         <p>
            <a href = "#" class = "btn btn-primary" role = "button">
               Add to Cart
            </a> 
            
            
         
      </div>
   </div>
   
   <div class = "col-sm-6 col-md-3">
      <div class = "thumbnail">
         <img src = "resources/led.jpg" alt = "Generic placeholder thumbnail">
      </div>
      
      <div class = "caption">
         <h3>Rs.650</h3>
         <p>Night lamp</p>
         
         <p>
            <a href = "LoginHere" class = "btn btn-primary" role = "button">
               Add to Cart
            </a> 
            
         </p>
         
      </div>
   </div>
   
   <div class = "col-sm-6 col-md-3">
      <div class = "thumbnail">
         <img src = "resources/watch.jpg" alt = "Generic placeholder thumbnail">
      </div>
      
      <div class = "caption">
         <h3>RS.750</h3>
         <p>Watches</p>
          
            <a href = "LoginHere" class = "btn btn-primary" role = "button">
               Add to cart
            </a>
         </p>
         
      </div>
   </div>
   
</div>
<%@ include file="footer1.jsp" %>
</body>
</html>

