package com.me.movie;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.dao.UserDao;
import com.me.exception.UserException;
import com.me.pojo.User;

@Controller
public class AdminController {
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/admin/delete.htm", method = RequestMethod.GET)
	public String showUsers(Model model) throws UserException {
		List<User> u =	userDao.getAllUsers();
		model.addAttribute("u", u);
		return "delete-user";
	}
	@RequestMapping(value = "/admin/deleteUser.htm", method = RequestMethod.GET)
	public String deleteUser(Model model,HttpServletRequest request) throws UserException
	{	try {
		long id = Long.valueOf(request.getParameter("id"));
		System.out.println("user id " + id);
		userDao.delete(userDao.getUserById(id));
		return showUsers(model);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "home";
	}
	@RequestMapping(value = "/admin/remove.htm", method = RequestMethod.GET)
	public String updateUser(Model model,HttpServletRequest request) throws UserException
	{
		long id = Long.valueOf(request.getParameter("id"));
		userDao.changeUserType(id);
		return showUsers(model);
	}
}
