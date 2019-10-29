package com.me.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.me.pojo.Movie;
import com.me.pojo.Review;
import com.me.pojo.User;

import com.me.exception.UserException;


@SuppressWarnings("deprecation")
public class UserDao extends DAO {
	public User addUser(User user) {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(user);
			commit();
		}
		 catch(HibernateException e) {
			 e.printStackTrace();
		 }
		close();
		return user;
	}
	
	public User getUser(String username,String password) throws UserException {
		
		try {
			System.out.print("in getuser");
			begin();
			Query q = getSession().createQuery("from User where uName = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			commit();
			close();
			return user;
		} catch (HibernateException e) {
			System.out.print("prolly a problem");
			rollback();
			throw new UserException("no user Found");
		}
	}
	public List<User> getCritics() throws UserException {
		try {
		begin();
		Query q = getSession().createQuery("from User where uType = 2");
		List<User> user = (List<User>) q.list();
		commit();
		close();
		return user;
		}
	 catch (HibernateException e) {
		System.out.print("prolly a problem");
		rollback();
		throw new UserException("no user Found");
	}
}
	public void delete(User u) {
		try {
			begin();
			getSession().delete(u);
			System.out.println("Is this here");
			commit();
		} catch (HibernateException e) {
			rollback();
			System.out.println(" Or here");
			e.printStackTrace();
		}
		close();
	}
	
	public User getUserById(long id) {
		try {
			begin();
			Criteria c = getSession().createCriteria(User.class);
			Criterion c1 = Restrictions.eq("userID", id);
			c.add(c1);
			User u = (User)c;
			close();
			return u;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			rollback();
		}
		return null;
	}
	
	public void changeUserType(long id) {
		
		User u = getUserById(id);
		delete(u);
		u.setuType("1");
		addUser(u);
	}
	public List<User> getAllUsers() throws UserException{
		try {
			begin();
			Query q = getSession().createQuery("from User");
			List<User> user = (List<User>) q.list();
			commit();
			close();
			return user;
			}
		 catch (HibernateException e) {
			System.out.print("prolly a problem");
			rollback();
			throw new UserException("no user Found");
		}
	}

}
