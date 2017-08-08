package com.LetsChatBE.dao;

import java.util.List;
import com.LetsChatBE.model.ForumPost;
import com.LetsChatBE.model.ForumComment;


public interface ForumPostDao {

	ForumPost getForumById(int id);

	List<ForumPost> getAllForums(int approved);

	List<ForumComment> getForumComments(int forumId);

	void saveForumPost(ForumPost forumPost);

	void updateforumPost(ForumPost forumPost);

	void addComment(ForumComment forumComment);

}
