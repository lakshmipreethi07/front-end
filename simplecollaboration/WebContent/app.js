var app=angular.module('myApp',['ngRoute']);
app.config(function($routeProvider){
	$routeProvider
	.when('/aboutus',{
		templateurl:'Aboutus/about.html',
		controller:'aboutController'
	})
	
app.controller('AboutController', function($scope) {
	  $scope.message = 'About Us';
	});
});