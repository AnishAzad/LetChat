package com.LetsChatBE.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;



@Entity
@Table(name="A_profilePicture")
@Component
public class ProfilePicture {
	
	@Id
	private String Username;
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Lob
	private byte[] image;

}
