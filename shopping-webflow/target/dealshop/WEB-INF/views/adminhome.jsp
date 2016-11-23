<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Case</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
lk:link,link:visited {
    background-color: #f44336;
    color: white;
    padding: 14px 25px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
}


lk:hover,lk:active {
    background-color: red;
}
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Shop 360degree</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Books and More<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Stationery</a></li>
            <li><a href="#">Music</a></li>
            <li><a href="#">Sports</a></li>
          </ul>
<li class="dropdown">
 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Electronics<span class="caret"></span></a>
          <ul class="dropdown-menu">
      <li>  <a href="#">Mobiles</a><li>
      <li>  <a href="#">Laptops</a></li>
      </ul>
<li class="dropdown">
 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Appliances<span class="caret"></span></a>
          <ul class="dropdown-menu">
       <li> <a href="#">Home entertainments</a><li>
        <li><a href="#">Washing machines</a></li>
      </ul>

      <ul class="nav navbar-nav navbar-right">
        <li><a href="logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
<a href="manageCategories" class="btn btn-success" role="button">Manage Categories</a>
<a href="manageProducts" class="btn btn-success" role="button">Manage Products</a>
<a href="manageSuppliers" class="btn btn-success" role="button">Manage Supplier</a>
</div>


</div>
</body>
</html>

