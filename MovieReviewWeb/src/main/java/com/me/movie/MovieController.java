package com.me.movie;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.MovieDao;
import com.me.exception.MovieException;
import com.me.pojo.Movie;
import com.me.pojo.User;
import com.me.validator.MovieValidator;

@Controller
public class MovieController {
	@Autowired
	MovieValidator movievalidator;
	@Autowired 
	MovieDao movieDao;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(movievalidator);
	}

	
	@RequestMapping(value = "/movie/add.htm", method = RequestMethod.GET)
	public String addForm(Model model, Movie movie, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("user");
		if(u.getuType().equals("0")) {
		model.addAttribute("movie",movie);
		
		return "addmovie-form";
		}
		else {
			return "home";
		}
	}
	@RequestMapping(value = "/movie/add.htm", method = RequestMethod.POST)
	public String readForm(@Validated@ModelAttribute("movie") Movie movie,BindingResult bindingResult,ModelMap model) {
		
		if (bindingResult.hasErrors()) {
			return "addmovie-form";  
		}

		movieDao.addMovie(movie);
		return "admin-home";
	}
	@RequestMapping(value = "/movie/search.htm",method = RequestMethod.GET)
	public String searchMovie() {
		
		return "search-page";
	}
	@RequestMapping(value = "/movie/search.htm",method = RequestMethod.POST)
	public ModelAndView resultPage(HttpServletRequest request) throws MovieException {
		String criteria = request.getParameter("criteria");
		ModelAndView mv = null;
		try {
		String keyword = request.getParameter("keyword");
		List<Movie> movieList = movieDao.getMovies(criteria, keyword);
		mv=new ModelAndView("movie-search-result","movieList",movieList);
		}catch(HibernateException e) {
			e.printStackTrace();
		}
		
        return mv;
		 
	}
	
//	@RequestMapping(value = "/movie/movie/addReview.htm")
//	public String addReviewFrom( ) {
//		
//	}

}
