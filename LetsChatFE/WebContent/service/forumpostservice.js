app.factory('ForumPostService',function($http){
	var forumPostService={}
	
	forumPostService.saveForum=function(forumPost){
		return $http.post("http://localhost:8084/LetsChatBE/saveforumpost",forumPost)
	}
	
	forumPostService.forumsApproved=function(){
		return $http.get("http://localhost:8084/LetsChatBE/listofforums/"+1)
	}
	 
	forumPostService.forumsWaitingForApproval=function() {
		return $http.get("http://localhost:8084/LetsChatBE/listofforums/"+0)
	}
	forumPostService.getForumPost=function(id) {
		return $http.get("http://localhost:8084/LetsChatBE/getforumpost/"+id)
	}
	forumPostService.updateForumPost=function(forumpost) {
		return $http.put("http://localhost:8084/LetsChatBE/updateforumpost",forumpost)
	}
	forumPostService.addComment=function(forumComment) {
		return $http.post("http://localhost:8084/LetsChatBE/addforumcomment",forumComment)
	}
	forumPostService.getForumComments=function(forumId) {
		return $http.get("http://localhost:8084/LetsChatBE/getforumcomments/"+forumId);
	}
	return forumPostService;
})