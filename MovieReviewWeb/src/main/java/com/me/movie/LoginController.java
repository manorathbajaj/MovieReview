package com.me.movie;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.me.exception.UserException;
import com.me.pojo.User;
import com.me.validator.UserValidator;
@Controller
@RequestMapping(value = "/login.htm")
public class LoginController {
	@Autowired
	UserValidator uservalidator;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	User user;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(uservalidator);
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String home(Locale locale, Model model, User user,HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute("user", user);
		
		
		
		return "login-form";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String successView(HttpServletRequest request) throws UserException {
		HttpSession session = request.getSession();
		User u = userDao.getUser((String)request.getParameter("uName"),(String)request.getParameter("password"));
		if(u == null) {
			System.out.print("null-back");
			return "login-form";
		}
		session.setAttribute("user", u);
		if(u.getuType().equals("0")) {
			return "admin-home";
		}
		else {
		return "welcome";
		}
		}
	
		
}

