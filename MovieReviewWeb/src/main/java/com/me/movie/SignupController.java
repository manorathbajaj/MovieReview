package com.me.movie;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import javax.servlet.http.HttpServletRequest;

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

import com.me.dao.UserDao;
import com.me.pojo.User;
import com.me.validator.UserValidator;

@Controller
@RequestMapping(value = "/signup.htm")
public class SignupController {

	@Autowired
	UserValidator uservalidator;
	
	@Autowired
	UserDao userDao;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(uservalidator);
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model, User user, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("user", user);
		
		
		
		return "signup-form";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String successView(@Validated@ModelAttribute("user") User user,BindingResult bindingResult,ModelMap model) {
		if (bindingResult.hasErrors()) {
			return "signup-form";  //the are validation errors, go to the form view
		}
		//no errors, so go to the success view
		userDao.addUser(user);
		return "home";
	}
}
