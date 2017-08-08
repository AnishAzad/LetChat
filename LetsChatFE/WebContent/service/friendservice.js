/**
 * 
 */
app.factory('FriendService',function($http){
	var friendService={}
	
	friendService.suggestedUsers=function(){
		return $http.get("http://localhost:8084/LetsChatBE/suggesteduserslist")
	}
	
	friendService.sendFriendRequest=function(toUsername){
		return $http.get("http://localhost:8084/LetsChatBE/friendrequest/"+toUsername);
	}
	 
	friendService.pendingRequests=function() {
		return $http.get("http://localhost:8084/LetsChatBE/pendingrequests")
	}
	
	friendService.updatePendingRequest=function(fromId,status) {
		return $http.put("http://localhost:8084/LetsChatBE/updatependingrequest/"+fromId+"/"+status);
	}
	
	friendService.listOfFriends=function() {
		return $http.get("http://localhost:8084/LetsChatBE/listoffriends")
	}
	
	return friendService;
})