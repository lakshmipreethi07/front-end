'use strict'
console.log("start of user controller")
app.controller('UserController',[
                  'UserService' ,
                  '$Scope',
                  '$location',
                  '$rootScope',
                  function($Scope,UserService,$rootScope,$location){
                	  console.log("user controller..")
                	  var self=this;
                	  self.Userdetails={
                			  userid:'',
                			  username:'',
                			  password:'',
                			  email : '',
                			  contact: '',
                			  address :'',
                			  Role :'',
                			  isOnline:'',
                			  errorCode:'',
                			  errorMessage :''
                			  };
                	  self.users=[];
                	  
                	  self.fetchAllUsers = function(){
                		  console.log("fetch all users")
                		  UserService.fetchAllUsers().then(function(d){
                			  self.users=d;
                			   },function(errResponse){
                			   console.log("error while fetching users");
                	  });
                	  };
                	  
                	  app.controller('BlogController', function($scope) {
                		  $scope.message = 'Hello from BlogController';
                		});

                		app.controller('AboutController', function($scope) {
                		  $scope.message = 'Hello from AboutController';
                		});  
                	  self.createUser=function(Userdetails){
                		  console.log("create users")
                		  UserService.createUser(Userdetails).then(self.fetchAllUsers
                				  ,function(errorResponse){
                			  console.log("error while creating users");  
                		  });
                		  };
                		  
                		  self.login=function(){
                		  {
                			  console.log('Login Validation....', self.Userdetails);
                			  self.authenticate(self.Userdetails);
                			  
                		  }
                		  };
                		  self.authenticate=function(Userdetails){
                			  console.log("authenticate")
                			  UserService.authenticate(Userdetails).then(
                					  function(d){
                				  self.Userdetails=d;
                				  if($rootScope.currentUser)
                					  {
                					  console.log("Valid User..Navigating to home page");
                					  $location.path('/');
                					  }
                				  else
                					  {
                					  console.log("invalid credentials..Staying on same page");
                					  self.Userdetails.userid="";
                					  }
                			  });
                			  
                		  };
                		  
                		  
                	self.submit=function(){
                		{
                		console.log("saving user",self.Userdetails);
                		self.createUser(self.userdetails);
                	}
                	self.reset();
                  };
                  
                  self.reset=function(){
                	  self.Userdetails={
                			  userid:'',
                			  username:'',
                			  password:'',
                			  email : '',
                			  contact: '',
                			  address :'',
                			  Role :'',
                			  errorCode:'',
                			  errorMessage :''
                			  };
                	
                  };
                  }]);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*function($scope) {
	  $scope.message = 'Hello from HomeController';
	});

	app.controller('BlogController', function($scope) {
	  $scope.message = 'Hello from BlogController';
	});

	app.controller('AboutController', function($scope) {
	  $scope.message = 'Hello from AboutController';
	});
*//**
 * 
 */