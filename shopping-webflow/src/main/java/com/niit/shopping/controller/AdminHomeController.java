package com.niit.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopping.dao.CategoryDAO;
import com.niit.shopping.dao.ProductDAO;
import com.niit.shopping.dao.SupplierDAO;
import com.niit.shopping.model.Category;
import com.niit.shopping.model.Product;
import com.niit.shopping.model.Supplier;



@Controller
public class AdminHomeController {
	
	
	@Autowired
	private Category category;
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private Supplier supplier;
	
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private Product product;
	
	
	@Autowired
	private ProductDAO productDAO;
	
	
	
	
	@RequestMapping("/manageCategories")
	public ModelAndView categories()
	{
		ModelAndView mv = new ModelAndView("Category");
		mv.addObject("category",category);
		mv.addObject("isAdminClickedCategories","true");
		mv.addObject("categoryList",categoryDAO.list());
		return mv;
		
	}

	@RequestMapping("/manageSuppliers")
	public ModelAndView suppliers()
	{
		ModelAndView mv = new ModelAndView("Supplier");
		mv.addObject("supplier",supplier);
		mv.addObject("isAdminClickedSuppliers","true");
		mv.addObject("supplierList",supplierDAO.list());
		return mv;
		
	}
	@RequestMapping("/manageProducts")
	public ModelAndView products()
	{
		ModelAndView mv = new ModelAndView("Product");
		mv.addObject("product",product);
		mv.addObject("isAdminClickedProducts","true");
		
		mv.addObject("productList",productDAO.list());
		mv.addObject("category",category);
		mv.addObject("categoryList",categoryDAO.list());
		mv.addObject("supplier",supplier);
		mv.addObject("supplierList",supplierDAO.list());
		return mv;
		
	}
	
	
	
	
}
