/*package com.LetsChatBE.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="A_forumcomment")
@Component
public class ForumComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="username")
	private Users commentedBy;
	private Date commentedOn;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="forumpost_id")
	private ForumPost forumPost;
	private String body;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getCommentedBy() {
		return commentedBy;
	}
	public void setCommentedBy(Users commentedBy) {
		this.commentedBy = commentedBy;
	}
	public Date getCommentedOn() {
		return commentedOn;
	}
	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}
	public ForumPost getForumPost() {
		return forumPost;
	}
	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
		

}
*/


package com.LetsChatBE.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="A_forumcomment")
public class ForumComment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	@JoinColumn(name="username")
	private Users commentedBy;
	private Date commentedOn;
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="Forumpost_id")
	private ForumPost forumPost;
	private String body;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Users getCommentedBy() {
		return commentedBy;
	}
	public void setCommentedBy(Users commentedBy) {
		this.commentedBy = commentedBy;
	}
	public Date getCommentedOn() {
		return commentedOn;
	}
	public void setCommentedOn(Date commentedOn) {
		this.commentedOn = commentedOn;
	}
	public ForumPost getForumPost() {
		return forumPost;
	}
	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}

