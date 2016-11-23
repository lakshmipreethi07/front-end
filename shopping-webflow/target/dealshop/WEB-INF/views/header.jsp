<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  </head>
  <style>
  .jumbotron {
    margin-bottom: 0px;
   background-image: url(resources/lamp.jpg);
    background-position: 0% 25%;
    background-size: cover;
    background-repeat: no-repeat;
    
    height:250px;
    font-color:white;
}
h1{
font-color:white;}
</style>
  <body>
 
<div class="jumbotron">
  <h1></h1>
</div>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Shop 360Degree</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Products <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Electronics</a></li>
          <li><a href="#">Stationery</a></li>
          <li><a href="#">Watches</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="Register"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
      <li><a href="LoginHere"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
    <li>  <a href="user/cart" >
				<span class="glyphicon glyphicon-hand-right"></span>View Cart</a></li>
								
      
    </ul>
    </div>
  </div>
</nav>
</body>
</html>

  
