package com.LetsChatBE.dao;

import com.LetsChatBE.model.ProfilePicture;

public interface ProfilePictureDao {

	void saveProfilePicture(ProfilePicture profilePicture);

	ProfilePicture getProfilePicture(String username);

}
