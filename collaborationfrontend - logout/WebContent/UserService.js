'use strict';
 
app.factory('UserService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("UserService...")
	
	var BASE_URL='http://localhost:8081/CollaborationBack'
		
    return {
         
            fetchAllUsers: function() {
            	console.log("calling fetchAllUsers ")
                    return $http.get(BASE_URL+'/users')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching UserDetailss');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            
            myProfile: function() {
            	console.log("calling fetchAllUsers ")
                    return $http.get(BASE_URL+'/myProfile')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching profile');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            createUser: function(user){
            	console.log("calling create user")
                    return $http.post(BASE_URL+'/createusers/', user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            updateUser: function(Userdetails, userid){
            	console.log("calling fetchAllUsers ")
                    return $http.put(BASE_URL+'/user/', user)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating user');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
              
            logout: function(){
            	console.log('logout....')
                return $http.post(BASE_URL+'/user/logout/')
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                              null
                        );
        },
        
        
            
            authenticate: function(Userdetails){
            	   console.log("Calling the method authenticate with the user :"+Userdetails)
          		 
                return $http.post(BASE_URL+'/user/authenticate/',Userdetails)
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                               null
                        );
        }
         
    };
 
}]);