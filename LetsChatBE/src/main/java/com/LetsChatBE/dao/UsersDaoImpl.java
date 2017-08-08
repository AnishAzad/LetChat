package com.LetsChatBE.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.LetsChatBE.model.Users;
import com.LetsChatBE.dao.UsersDao;


@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void registration(Users users){
	Session session=sessionFactory.openSession();
	session.save(users);
	session.flush();
	session.close();
	
}

public List<Users> getAllUsers(){
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Users");
	List<Users> users=query.list();
	session.close();
	return users;
}


public Users login(Users users){
	Session session=sessionFactory.openSession();
	Query query=session.createQuery("from Users where username=? and password=? and enabled=?");
	query.setString(0, users.getUsername()); // for assigning the value to the parameter username.
	query.setString(1, users.getPassword());
	query.setBoolean(2, true);
	query.uniqueResult();
	Users validUsers=(Users)query.uniqueResult();
	session.close();
	return validUsers;
}

public Users updateUser(Users validUser){
    Session session=sessionFactory.openSession();
    //update BF_USERS set on_line=true where username='jana'
    session.update(validUser);
    session.flush();
    session.close();
    return validUser;
}
 
public Users getUserByUsername(String username){
    Session session=sessionFactory.openSession();
    Users users=(Users)session.get(Users.class,username);
    session.close();
    return users;
  }
}
