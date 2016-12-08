var app = angular.module('myApp', ['ngRoute','ngCookies']);

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
.when('/friend', {
    templateUrl : 'c_friend/search_friend.html',
    controller  : 'FriendController'
  })
.when('/viewfriend', {
    templateUrl : 'c_friend/view_friend.html',
    controller  : 'FriendController'
  })

.when('/listofblogs', {
    templateUrl : 'c_blog/list_blog.html',
    controller  : 'BlogController'
  })
.when('/createblog', {
    templateUrl : 'c_blog/create_blog.html',
    controller  : 'BlogController'
  })
.when('/logout', {
    templateUrl : 'pages/blog.html',
    controller  : 'UserController'
  })
.when('/chat', {
    templateUrl : 'c_chat/Chat.html',
    controller  : 'ChatCtrl'
  })
  

  .otherwise({redirectTo: '/'});
});
app.run(function ($rootScope, $location, $cookieStore, $http){

	$rootScope.$on('$locationChangeStart', function(event, next, current){
	console.log("$locationChangeStart")
	//redirect to login page if not logged in and typing to access a restricted page

	var restrictedPage=$.inArray($location.path(), ['/login','/register','/list_blog']) ===-1;
	console.log("restrictedPage:" +restrictedPage)
	var loggedIn=$rootScope.currentUser.userid;
	console.log("loggedIn:"+loggedIn)
	if(restrictedPage & !loggedIn){
	console.log("Navigating to login page:")
	alert("You are not logged and so you can't do this operation")
	$location.path('/login');
	}
	});

	//keep user logged in after page refresh
	$rootScope.currentUser = $cookieStore.get('currentUser') || {};
	if($rootScope.currentUser){
	$http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.currentUser;
	
	}
	});