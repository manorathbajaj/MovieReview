package com.me.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import java.util.List;
import com.me.pojo.Movie;

import com.me.exception.MovieException;

//import antlr.collections.List;

public class MovieDao extends DAO{
	
	public Movie addMovie(Movie movie) {
		try {
			begin();
			System.out.println("inside DAO");
			getSession().save(movie);
			commit();
			close();
		}
		 catch(HibernateException e) {
			 e.printStackTrace();
		 }
		
		return movie;
	}
	public List<Movie> getMovies(String criteria,String keyword) throws com.me.exception.MovieException{
		try {
		begin();
		@SuppressWarnings("deprecation")
		Criteria c = getSession().createCriteria(Movie.class);
		Criterion c1 = Restrictions.ilike(criteria, "%"+keyword+"%");
		c.add(c1);
//		List results = c.list();
		List<Movie> movies = c.list();
		close();
		return movies;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			rollback();
			throw new com.me.exception.MovieException("Could not List movie", e);
		}		
	}
	public Movie getMovieById(long id) throws com.me.exception.MovieException{
		try {
		begin();
		@SuppressWarnings("deprecation")
		Criteria c = getSession().createCriteria(Movie.class);
		Criterion c1 = Restrictions.eq("movieId", id);
		c.add(c1);
		Movie movie = (Movie) c.uniqueResult();
		close();
		return movie;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			rollback();
	
		}
		return null;
		
		
		
	}
}
