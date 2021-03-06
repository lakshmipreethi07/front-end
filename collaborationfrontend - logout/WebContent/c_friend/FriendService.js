'use strict';
 
app.factory('FriendService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("FriendService...")
	
	var BASE_URL='http://localhost:8081/CollaborationBack'
    return {
         
		getMyFriends: function() {
                    return $http.get(BASE_URL+'/myfriends')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                   null
                            );
            },
             
   getmyfriendrequest : function() {
                return $http.get(BASE_URL+'/getmyfriendRequest')
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                               null
                        );
        },
    
            
            
            sendFriendRequest: function(friendid){
                    return $http.get(BASE_URL+'/addfriend/'+friendid)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while creating friend');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
            acceptFriendRequest: function(friendid){
                return $http.get(BASE_URL+'/acceptFriend/'+friendid)
                        .then(
                                function(response){
                                    return response.data;
                                }, 
                                function(errResponse){
                                    console.error('Error while accepting friend');
                                    return $q.reject(errResponse);
                                }
                        );
        },
        
            updateFriendRequest: function(friend, id){
                    return $http.put(BASE_URL+'/friend/'+id, friend)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while updating friend');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
             
           /* deleteFriend: function(id){
                    return $http.delete(BASE_URL+'/friend/'+id)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while deleting friend');
                                        return $q.reject(errResponse);
                                    }
                            );
            }*/
            
           
         
    };
 
}]);