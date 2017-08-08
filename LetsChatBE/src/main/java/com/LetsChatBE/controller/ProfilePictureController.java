package com.LetsChatBE.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.LetsChatBE.dao.ProfilePictureDao;
import com.LetsChatBE.model.ProfilePicture;
import com.LetsChatBE.model.Users;
import com.LetsChatBE.model.Error;

@RestController("profilePictureController")
public class ProfilePictureController {
	
	@Autowired
	private ProfilePictureDao profilePictureDao;
	@RequestMapping(value="/uploadprofilepic",method=RequestMethod.POST)
	public ResponseEntity<?> uploadProfilePicture(@RequestParam CommonsMultipartFile image,HttpSession session){
		Users users=(Users)session.getAttribute("user");
		if(users==null){
			Error error=new Error(3,"UnAuthorized user");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		
		ProfilePicture profilePicture=new ProfilePicture();
		profilePicture.setUsername(users.getUsername());
		profilePicture.setImage(image.getBytes());
		profilePictureDao.saveProfilePicture(profilePicture);
		return new ResponseEntity<Users>(users,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getimage/{username}",method=RequestMethod.GET)
	public @ResponseBody byte[] getProfilePic(@PathVariable String username,HttpSession session){
		Users users=(Users)session.getAttribute("user");
		if(users==null)
			return null;
			else
			{
				ProfilePicture profilepic=profilePictureDao.getProfilePicture(username);
			if(profilepic==null)
				return null;
				else
					return profilepic.getImage();
			}
		}
		}

		


