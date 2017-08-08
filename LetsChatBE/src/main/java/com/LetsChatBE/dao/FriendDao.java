package com.LetsChatBE.dao;

import java.util.List;

import com.LetsChatBE.model.Friend;
import com.LetsChatBE.model.Users;

public interface FriendDao {

	List<Users> listOfSuggestedUsers(String username);

	void friendRequest(String fromUsername, String toUsername);

	List<Friend> listOfPendingRequests(String username);

	void updatePendingRequest(String fromId, String username, char status);

	List<Friend> listOfFriends(String username);

}
