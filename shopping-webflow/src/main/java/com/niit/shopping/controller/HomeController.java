package com.niit.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopping.dao.UserdetailsDAO;

import javax.servlet.http.HttpSession;

import com.niit.shopping.model.Userdetails;

@Controller
public class HomeController {

	@Autowired
	Userdetails userdetails;
	@Autowired(required=true)
	UserdetailsDAO userdetailsDAO;
	
	@RequestMapping("/")
	public ModelAndView onLoad(HttpSession session)
	{
	ModelAndView mv = new ModelAndView("home");

	return mv;
	}
	@RequestMapping("Register")
public ModelAndView register()
{
	ModelAndView mv = new ModelAndView("Register");
	mv.addObject("userDetails", userdetails);
	mv.addObject("isUserClickedRegisterHere", "true");
	return mv;
}

@RequestMapping("LoginHere")
public ModelAndView loginHere()
{
	ModelAndView mv = new ModelAndView("Login");
	mv.addObject("userDetails", userdetails);
	mv.addObject("isUserClickedLoginHere", "true");
	return mv;
}
	
@RequestMapping(value="RegisterSuccess",method = RequestMethod.POST)
public ModelAndView registerUser(@ModelAttribute Userdetails userdetails)
{
	ModelAndView mv = new ModelAndView("Login");
	if(userdetailsDAO.get(userdetails.getUsername())==null)
	{
		userdetailsDAO.save(userdetails);
		mv.addObject("msg","you are successfully register");
	}
	else
	{
		mv.addObject("msg", "user exist with this id");
	}
	
	mv.addObject("isUserClickedSubmit", "true");
	return mv;
}
}
