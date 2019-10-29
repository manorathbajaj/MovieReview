package com.me.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.me.exception.ReviewException;
import com.me.pojo.Movie;
import com.me.pojo.Review;


public class ReviewDao extends DAO {
	public Review create(Review review) throws ReviewException {
        try {
            begin();  
            System.out.println(review.getMovie());
            getSession().save(review);     
            commit();
            close();
            return review;
        } catch (HibernateException e) {
            rollback();
            throw new ReviewException("Exception while creating review: " + e.getMessage());
        }
    }
	
	public List<Review> getReviewsById(long movieId) throws ReviewException{
		try {
		begin();
		@SuppressWarnings("deprecation")
		Criteria c = getSession().createCriteria(Review.class);
		Criterion c1 = Restrictions.eq("movieId", movieId);
		c.add(c1);
//		List results = c.list();
		List<Review> movie = (List<Review>) c.list();
		close();
		return movie;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			rollback();
			throw new com.me.exception.ReviewException("Could not List movie", e);
		}
	}
	
 
}
