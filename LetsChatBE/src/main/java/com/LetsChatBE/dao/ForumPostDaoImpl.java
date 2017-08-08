package com.LetsChatBE.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LetsChatBE.model.ForumComment;
import com.LetsChatBE.model.ForumPost;
import com.LetsChatBE.dao.ForumPostDao;
//import com.LetsChatBE.model.ForumComment;
//import com.LetsChatBE.model.ForumPost;

@Repository
public class ForumPostDaoImpl implements ForumPostDao  {

	@Autowired
	  private SessionFactory sessionFactory;
		public void saveForumPost(ForumPost forumPost) {
			Session session=sessionFactory.openSession();
			session.save(forumPost);
			session.flush();
			session.close(); 
			
		}
		public List<ForumPost> getAllForums(int approved) {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from ForumPost where approved="+approved);
			List<ForumPost> forumPosts=query.list();
			session.close();
			return forumPosts;
			
		}
		public ForumPost getForumById(int id) {
			Session session=sessionFactory.openSession();
			ForumPost forumPost=(ForumPost)session.get(ForumPost.class,id);
			session.close();
			return forumPost;
		}
		
		public void updateforumPost(ForumPost forumPost) {
			Session session=sessionFactory.openSession();
			session.update(forumPost);
			session.flush();
			session.close();
			
		}
		public void addComment(ForumComment forumComment) {
			Session session=sessionFactory.openSession();
			session.save(forumComment);
			session.flush();
			session.close();
		}
		
		public List<ForumComment> getForumComments(int forumId) {
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from ForumComment where forumPost.id"+forumId);
			List<ForumComment> forumComments=query.list();
			System.out.println(forumComments);
			session.close();
			return forumComments;
			
		}

}
