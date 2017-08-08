/**
 * BlogPostService for Blog module
 */
app.factory('BlogPostService',function($http){
	var blogPostService={}
	
	blogPostService.saveBlog=function(blogPost){
		return $http.post("http://localhost:8084/LetsChatBE/saveblogpost",blogPost)
	}
	
	blogPostService.blogsApproved=function(){
		return $http.get("http://localhost:8084/LetsChatBE/listofblogs/"+1)
	}
	 
	blogPostService.blogsWaitingForApproval=function() {
		return $http.get("http://localhost:8084/LetsChatBE/listofblogs/"+0)
	}
	blogPostService.getBlogPost=function(id) {
		return $http.get("http://localhost:8084/LetsChatBE/getblogpost/"+id)
	}
	blogPostService.updateBlogPost=function(blogpost) {
		return $http.put("http://localhost:8084/LetsChatBE/updateblogpost",blogpost)
	}
	blogPostService.addComment=function(blogComment) {
		return $http.post("http://localhost:8084/LetsChatBE/addblogcomment",blogComment)
	}
	 blogPostService.getBlogComments=function(blogId) {
		return $http.get("http://localhost:8084/LetsChatBE/getblogcomments/"+blogId);
	}
	return blogPostService;
})