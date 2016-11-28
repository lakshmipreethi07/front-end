var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : 'pages/home.html',
    controller  : 'HomeController'
  })

  .when('/blog', {
    templateUrl : 'pages/blog.html',
    controller  : 'BlogController'
  })

  .when('/about', {
    templateUrl : 'pages/about.html',
    controller  : 'AboutController'
  })
  .when('/login', {
    templateUrl : 'pages/login.html',
    controller  : 'UserController'
  })
 .when('/register', {
    templateUrl : 'pages/register.html',
    controller  : 'UserController'
  })
.when('/logout', {
    templateUrl : 'pages/about.html',
    controller  : 'UserController'
  })
.when('/friend', {
    templateUrl : 'c_friend/search_friend.html',
    controller  : 'FriendController'
  })

  

  .otherwise({redirectTo: '/'});
});
