'use strict';
 
app.controller('FriendController', ['UserService','$scope', 'FriendService','$location',
   '$rootScope',function(UserService,$scope, FriendService,$location,$routeParams,$rootScope) {
	console.log("FriendController...")
          var self = this;
          self.friend={id:'',userid:'',friendid:'',status:''};
          self.friends=[];
          
          self.user = {
  				userid : '',
  				username : '',
  				password : '',
  				contact : '',
  				address : '',
  				email : '',
  				is_online:'',
  				Role : '',
  				errorMessage : ''
  			};
  			self.users = [];
          
         self.sendFriendRequest=sendFriendRequest
         
         function sendFriendRequest(friendid)
         {

       	  console.log("->sendFriendRequest :"+friendid)
             FriendService.sendFriendRequest(friendid)
                 .then(
                              function(d) {
                                   self.friend = d;
                                  alert("Friend request sent")
                              },
                               function(errResponse){
                                   console.error('Error while sending friend request');
                               }
                      );
         
        	 self.acceptFriendRequest=acceptFriendRequest
        	 
        	 function acceptFriendRequest(friendid)
        	 {

              	  console.log("->sendFriendRequest :"+friendid)
                    FriendService.sendFriendRequest(friendid)
                        .then(
                                     function(d) {
                                          self.friend = d;
                                         alert(" accepted friend request")
                                     },
                                      function(errResponse){
                                          console.error('Error while accepting friend request');
                                      }
                             );

         }
          
             
          self.getMyFriends = function(){
        	  console.log("Getting my friends")
              FriendService.getMyFriends()
                  .then(
                               function(d) {
                                    self.friends = d;
                                    console.log("Got the friends list")
                                     	/* $location.path('/view_friend');*/
                               },
                                function(errResponse){
                                    console.error('Error while fetching Friends');
                                }
                       );
          };
          self.getmyfriendrequest = function(){
        	  console.log("Getting my friendrequest")
              FriendService.getmyfriendrequest()
                  .then(
                               function(d) {
                                    self.friends = d;
                                    console.log("Got the friend request list")
                                     	/* $location.path('/view_friend');*/
                               },
                                function(errResponse){
                                    console.error('Error while fetching Friends');
                                }
                       );
          };
            
         
       
         self.updateFriendRequest = function(friend, id){
              FriendService.updateFriendRequest(friend, id)
                      .then(
                              self.fetchAllFriends, 
                              function(errResponse){
                                   console.error('Error while updating Friend.');
                              } 
                  );
          };
 
         self.deleteFriend = function(id){
              FriendService.deleteFriend(id)
                      .then(
                              self.fetchAllFriends, 
                              function(errResponse){
                                   console.error('Error while deleting Friend.');
                              } 
                  );
          };
          
          self.fetchAllUsers = function() {
				UserService.fetchAllUsers().then(function(d) {
					self.users = d;
				}, function(errResponse) {
					console.error('Error while fetching Users');
				});
			};
            
 
          self.fetchAllUsers();
          self.getMyFriends();
          self.getmyfriendrequest();
 
     
 
      }]);