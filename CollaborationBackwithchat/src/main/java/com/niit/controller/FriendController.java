package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.dao.FriendDAO;

import com.niit.model.Friend;
import com.niit.model.Userdetails;

@RestController
public class FriendController {
	
	@Autowired
	FriendDAO friendDAO;
	@Autowired
	Friend friend;
	
	
	private static final Logger log=LoggerFactory.getLogger(Friend.class);
	@RequestMapping(value="/myfriends", method=RequestMethod.GET)
	public ResponseEntity<List<Friend>> listAllFriend(HttpSession session){
		log.debug("-->Calling method listAllFriends");
		Userdetails loggedInUser = (Userdetails) session.getAttribute("loggedInUser");
		List<Friend> myfriends = friendDAO.getmyfriends(loggedInUser.getUserid());
		return new ResponseEntity<List<Friend>> (myfriends,HttpStatus.OK);
		
	}
		
	@RequestMapping(value="/addfriend/{friendid}", method=RequestMethod.GET)
	public ResponseEntity<Friend> sendFriendRequest(@PathVariable("friendid")String friendid,HttpSession session)
	{
		log.debug("-->Calling method send friend request");
		String loggedInUserid = (String) session.getAttribute("loggedInUserId");
		friend.setUserid(loggedInUserid);
		friend.setFriendid(friendid);
		friend.setStatus("N");
		friendDAO.save(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	@RequestMapping(value="/unfriend/{friendid}", method=RequestMethod.GET)
	public ResponseEntity<Friend> unfriend(@PathVariable("friendid")String friendid,HttpSession session)
	{
		log.debug("-->Calling method send friend request");
		Userdetails loggedInUser = (Userdetails) session.getAttribute("loggedInUser");	
		friend.setUserid(loggedInUser.getUserid());
		friend.setFriendid(friendid);
		friend.setStatus("U");
		friendDAO.update(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	@RequestMapping(value="/rejectFriend/{friendid}", method=RequestMethod.GET)
	public ResponseEntity<Friend> rejectFriend(@PathVariable("friendid")String friendid,HttpSession session)
	{
		log.debug("-->Calling method send friend request");
		Userdetails loggedInUser = (Userdetails) session.getAttribute("loggedInUser");	
		friend.setUserid(loggedInUser.getUserid());
		friend.setFriendid(friendid);
		friend.setStatus("R");
		friendDAO.update(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getmyfriendRequest", method=RequestMethod.GET)
	public ResponseEntity<Friend> getFriendRequest(HttpSession session){
		log.debug("-->Calling method listAllFriends");
		String loggedInUserid = (String) session.getAttribute("loggedInUserId");

		friendDAO.getNewFriendrequest(loggedInUserid);
		return new ResponseEntity<Friend> (friend,HttpStatus.OK);
	
}
	@RequestMapping(value="/acceptFriend/{friendid}", method=RequestMethod.GET)
	public ResponseEntity<Friend> acceptFriend(@PathVariable("friendid")String friendid,HttpSession session)
	{
		log.debug("-->Calling method send friend request");
		String loggedInUserId = (String) session.getAttribute("loggedInUserId");
		friend.setUserid(loggedInUserId);
		friend.setFriendid(friendid);
		friend.setStatus("A");
		friendDAO.update(friend);
		//updateRequest(friendid,"A",session);
		return new ResponseEntity<Friend> (friend,HttpStatus.OK);
	}
	
	
	/*private void updateRequest(String friendid,String status,HttpSession session)
	{
		String loggedInUserId = (String) session.getAttribute("loggedInUserId");
		friend.setUserid(loggedInUserId);
		friend.setFriendid(friendid);
		friendDAO.update(friend);
	}*/
	
	@RequestMapping(value="/myfriends/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Friend>> getmyFriendsTemp(@PathVariable("id")String id){
		List<Friend> myfriends = friendDAO.getmyfriends(id);
		return new ResponseEntity<List<Friend>> (myfriends,HttpStatus.OK);
	}
}/*
	@RequestMapping(value = "/myFriends", method = RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriends(HttpSession session) {
		logger.debug("->->->->calling method getMyFriends");
		String loggedInUserID= (String) session.getAttribute("loggedInUserID");

		logger.debug("getting friends of : " +loggedInUserID);
		List<Friend> myFriends = friendDAO.getmyfriends(loggedInUserID);
		
		if(myFriends.isEmpty())
		{
			logger.debug("Friends does not exsit for the user : " +loggedInUserID);
			friend.setErrorcode("404");
			friend.setErrormessage("You does not have any friends");
			myFriends.add(friend);
		}
		logger.debug("Send the friend list ");
		return new ResponseEntity<List<Friend>>(myFriends, HttpStatus.OK);
	}

	@RequestMapping(value = "/addFriend/{friendID}", method = RequestMethod.GET)
	public ResponseEntity<Friend> sendFriendRequest(@PathVariable("friendID") String friendID,HttpSession session) {
		logger.debug("->->->->calling method sendFriendRequest");
		String loggedInUserID= (String) session.getAttribute("loggedInUserID");
		friend.setUserid(loggedInUserID);
		friend.setFriendid(friendID);
		friend.setStatus("N"); //N - New, R->Rejected, A->Accepted
		friendDAO.save(friend);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/unFriend/{friendID}", method = RequestMethod.GET)
	public ResponseEntity<Friend> unFriend(@PathVariable("friendID") String friendID,HttpSession session) {
		logger.debug("->->->->calling method unFriend");
		updateRequest(friendID, "U", session);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		
	}
	
	

	@RequestMapping(value = "/rejectFriend/{friendID}", method = RequestMethod.GET)
	public ResponseEntity<Friend> rejectFriendFriendRequest(@PathVariable("friendID") String friendID,HttpSession session) {
		logger.debug("->->->->calling method rejectFriendFriendRequest");
		
		updateRequest(friendID, "R", session);
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		
	}
	
	private void updateRequest(String friendID, String status,HttpSession session)
	{
		String loggedInUserID= (String) session.getAttribute("loggedInUserID");
		friend.setUserid(loggedInUserID);
		friend.setFriendid(friendID);
		friend.setStatus(status); //N - New, R->Rejected, A->Accepted
		friendDAO.update(friend);
		
	}
	
	
	@RequestMapping(value = "/getMyFriendRequests/", method = RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriendRequests(HttpSession session) {
		logger.debug("->->->->calling method getMyFriendRequests");
		String loggedInUserID= (String) session.getAttribute("loggedInUserID");
		List<Friend>  myFriendRequests =   friendDAO.getNewFriendrequest(loggedInUserID);
		return new ResponseEntity<List<Friend>>(myFriendRequests, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value = "/accepttFriend/{friendid}", method = RequestMethod.GET)
	public ResponseEntity<Friend> acceptFriendFriendRequest(@PathVariable("friendid") String friendid,HttpSession session) {
		logger.debug("->->->->calling method acceptFriendFriendRequest");
		logger.debug("-->Calling method send friend request");
		String loggedInUserId = (String) session.getAttribute("loggedInUserId");
		friend.setUserid(loggedInUserId);
		friend.setFriendid(friendid);
		friend.setStatus("A");
		friendDAO.update(friend);
		//updateRequest(friendid,"A",session);
		return new ResponseEntity<Friend> (friend,HttpStatus.OK);
			}
	
		

}
*/