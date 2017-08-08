/**
 * forumcontroller
 */
app.controller('ForumPostController',function($scope,ForumPostService,$location){
	$scope.message=''
		$scope.saveForumPost=function(){
		alert('entering save forum post')
		  ForumPostService.saveForum($scope.forumPost).then(function(response){
			  $scope.success="Forum post inserted successfully and waiting for approval"
			  $location.path('/getallforums')
		  },function(response){
			  $scope.message=response.data.message 
			  if(response.status==401){
				  
				  $location.path('/saveforumpost')
			  }
		   })
	    }
	/**
	 * List of forums which are approved - value of approved=1
	 */
	
	  $scope.forumsApproved=ForumPostService.forumsApproved().then(function(response){
		  $scope.forumsApproved=response.data;
		 },function(response){
			 console.log(response.status)
		 })
	/**
	 * List of forums which are waiting for approval - value of approved=0
	 */
	 
	 $scope.forumsWaitingForApproval=ForumPostService.forumsWaitingForApproval().then(function(response){
		  $scope.forumsWaitingForApproval=response.data;
	  },function(response){
		  console.log(response.status)
	  })

})
	 
