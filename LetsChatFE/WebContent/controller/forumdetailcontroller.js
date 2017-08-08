/**
 * ForumDetailController
 * getForumForApprova/14(id)
 * 14 is forumpost id
 * to read the value 14 from the route,$routeParam 
 */
app.controller('ForumDetailController',function($scope,$location,ForumPostService,$routeParams){
	var id=$routeParams.id
	$scope.showComments=false
	$scope.forumPost=ForumPostService.getForumPost(id).then(function(response){
		$scope.forumPost=response.data;
	},function(response){
		console.log(response.status)
	})
	$scope.updateApproval=function() {
		ForumPostService.updateForumPost($scope.forumPost).then(function(response){
         $location.path('/getallforums')
		},function(response){
			console.log(response.status);
			$location.path('/getForumForApproval/'+id)
		})
    }
	$scope.addComment=function(){
		$scope.forumComment.forumPost=$scope.forumPost
		ForumPostService.addComment($scope.forumComment).then(function(response){
			alert('Comment added successfully')
			$scope.forumComment.body=''
			console.log(response.status)
		},function(response){	
			console.log(response.status);
		})
	}
	$scope.getForumComments=function(forumId){
		$scope.showComments=true;
		ForumPostService.getForumComments(forumId).then(function(response){
			$scope.forumComments=response.data;
			console.log(response.data)
			console.log(response.status);
		},function(response){
			console.log(response.status)
			})
		}
	})