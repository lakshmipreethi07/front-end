package com.niit.shopping.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopping.dao.CategoryDAO;
import com.niit.shopping.dao.ProductDAO;
import com.niit.shopping.dao.UserdetailsDAO;
import com.niit.shopping.model.Userdetails;

@Controller
public class UserController {
	@Autowired
	UserdetailsDAO userdetailsDAO;
	
	@Autowired
	Userdetails userdetails;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	@RequestMapping("/Login")
	public ModelAndView login(@RequestParam(value = "name")String name, @RequestParam(value= "password")String password,HttpSession session)
	{
		ModelAndView model = new ModelAndView("home");
		String msg;
		userdetails = userdetailsDAO.isValidUser(name, password);
		if(userdetails== null)
		{
			msg = "Invalid user...please try again";
			
		}
		else
		{
			if(userdetails.getRole().equals("ROLE_ADMIN"))
			{
				ModelAndView mv = new ModelAndView("adminhome  ");
				mv = new ModelAndView("adminhome");
				return mv;
			}
			session.setAttribute("Welcome", userdetails.getUsername());
			
		}
		return model;
	}
	
@RequestMapping("/logout")
public ModelAndView logout(HttpServletRequest request,HttpSession session)
{
	ModelAndView mv= new ModelAndView("home");
	session.invalidate();
	session=request.getSession(true);
	mv.addObject("logoutMessage","You successfully logged out");
	mv.addObject("loggedOut", "true");
	return mv;
}
@RequestMapping( "/loginsuccess") //value should be same as given in authentication-success-forward-url tag in springsecurity.xml
public String login_session_attributes(HttpSession session,Model model) 
{
	//System.out.println("Hello");
	String username = SecurityContextHolder.getContext().getAuthentication().getName();
	
	Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
	String page="";
	
	String role="ROLE_USER";
	for (GrantedAuthority authority:authorities) 
	{
	 System.out.println(authority.getAuthority());
	     if (authority.getAuthority().equals(role)) 
	     {
	    	 
	    	 session.setAttribute("UserLoggedIn", "true");
	    	 session.setAttribute("Username", username);
	    	 model.addAttribute("categoryList",categoryDAO.list());
	    	 model.addAttribute("productList",productDAO.list());

	    	 page="productview2";
	    	 
	    	 break;
	     }
	     else 
	     {
	    	 session.setAttribute("LoggedIn", "true");
	    	 session.setAttribute("Admin", "true");
	    	 page="adminhome";
	    	 break;
	    }
	}
	return page;
}


	
}
