/**
 *  UserService for User module
 */
app.factory('UserService',function($http){
	var userService={}
	
	userService.registerUser=function(user){
		return $http.post("http://localhost:8084/LetsChatBE/registration",user)
	}
	
	userService.login=function(user){
		return $http.post("http://localhost:8084/LetsChatBE/login",user)
	}
	 
	userService.logout=function(){
		return $http.get("http://localhost:8084/LetsChatBE/logout")
	}
	
	userService.getUserByUsername=function(){
		return $http.get("http://localhost:8084/LetsChatBE/getuserdetails")
	}
	
	userService.updateUserProfile=function(user){
		return $http.put("http://localhost:8084/LetsChatBE/updateprofile",user)
	}
	return userService;
	})