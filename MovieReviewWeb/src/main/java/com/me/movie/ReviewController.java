package com.me.movie;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.MovieDao;
import com.me.dao.ReviewDao;
import com.me.dao.UserDao;
import com.me.exception.MovieException;
import com.me.exception.ReviewException;
import com.me.exception.UserException;
import com.me.pojo.Movie;
import com.me.pojo.Review;
import com.me.pojo.User;

@Controller
public class ReviewController {
	@Autowired
	MovieDao movieDao;
	@Autowired
	UserDao userDao;
	
	@Autowired 
	ReviewDao reviewDao;
	@Autowired
	Review review;
	
	@RequestMapping(value = "/movie/addreview.htm",method = RequestMethod.GET)
	public String  addResult(HttpServletRequest request,Model model,Review review) throws MovieException, ReviewException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null)
		{
			return "home";
		}
		long id = Integer.valueOf((String)request.getParameter("id"));
		Movie m = movieDao.getMovieById(id);
	//	model.addAttribute("movie", m);
		Set<Review> r = m.getReviews();
		int total = 0;
		int stars = 0;
		float avgRating;
		for(Review re : r ) {
		stars =  stars +	re.getStar();
		total++;
		}
		avgRating = stars/total;
		model.addAttribute("avgRating", avgRating);
		model.addAttribute("movie",m);
		
		return "review-page";
	}
	
	@RequestMapping(value = "/movie/addreview.htm",method = RequestMethod.POST)
	public String showPage(HttpServletRequest request,Review review) throws MovieException, ReviewException {
		HttpSession session = request.getSession();
		long id = Integer.valueOf((String)request.getParameter("id"));
		Movie m = movieDao.getMovieById(id);
		User u =  (User)session.getAttribute("user");
		review.setMovie(m);
		review.setPostedBy(u);
		review.setStar(Integer.valueOf(request.getParameter("star")));
		review.setComment(request.getParameter("comment"));
		review = reviewDao.create(review);
		return "welcome";
		
	}
	
	@RequestMapping(value = "/movie/critics.htm",method = RequestMethod.GET)
	public String showCritics(HttpServletRequest request, Model model) throws UserException {
		
		List<User> u = userDao.getCritics();
		model.addAttribute("critics", u);
		return "critic";
	}
}
