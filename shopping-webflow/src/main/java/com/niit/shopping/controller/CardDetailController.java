package com.niit.shopping.controller;





import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shopping.service.CardDetailService;
import com.niit.shopping.service.CartItemService;
import com.niit.shopping.service.CartService;
import com.niit.shopping.service.UsersDetailService;
import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Userdetails;
import com.niit.shopping.model.CardDetail;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


/*
 * This Controller is used to store user card information into the database
 */
@Controller
public class CardDetailController {
	
    @Autowired
    private CartService cartService;
    
    @Autowired
    private UsersDetailService userdetailsService;
    @Autowired
    CardDetail cardDetail;
    @Autowired
    private CartItemService cartItemService;
   
    @Autowired
    private CardDetailService cardService;
    /*
     * CardDetail method is used to open card detail form
     */
    @RequestMapping("/cardDetail")
    public String CardDetail(Model model) {
    	
    	CardDetail cardDetail = new CardDetail();
        model.addAttribute("carddetail", cardDetail);
    	return "cardDetail";

    }
    /*
     * CardDetailPost method is used to store user card information into the system
     */
    @RequestMapping(value = "/cardDetail/{cartId}", method = RequestMethod.POST)
    public String CardDetailPost(@PathVariable(value ="cartId") int cartId, @Valid @ModelAttribute("carddetail") CardDetail cardDetail, BindingResult result,Principal username ,Model model) {
    	List<String> cardTypeList = new ArrayList<String>();
    	cardTypeList.add("Visa-Debit/Credit");
    	cardTypeList.add("Mastercard");
    	List<String> expiryMonthList = new ArrayList<String>();
    	expiryMonthList.add("01");
    	expiryMonthList.add("02");
    	expiryMonthList.add("03");
    	expiryMonthList.add("04");
    	expiryMonthList.add("05");
    	expiryMonthList.add("06");
    	expiryMonthList.add("07");
    	expiryMonthList.add("08");
    	expiryMonthList.add("09");
    	expiryMonthList.add("10");
    	expiryMonthList.add("11");
    	expiryMonthList.add("12");
    	List<String> expiryYearList = new ArrayList<String>();
    	expiryYearList.add("2016");
    	expiryYearList.add("2017");
    	expiryYearList.add("2018");
    	expiryYearList.add("2019");
    	expiryYearList.add("2020");
    	expiryYearList.add("2021");
    	expiryYearList.add("2022");
    	expiryYearList.add("2023");
    	expiryYearList.add("2024");
    	expiryYearList.add("2025");
    	expiryYearList.add("2026");
    	expiryYearList.add("2027");
    	expiryYearList.add("2028");
    	expiryYearList.add("2029");
    	expiryYearList.add("2030");
    	model.addAttribute("cardTypeList",cardTypeList);
    	model.addAttribute("expiryMonthList",expiryMonthList);
    	model.addAttribute("expiryYearList",expiryYearList);
    	Userdetails userdetails = userdetailsService.getUserByUsername(username.getName());
    	Cart cart = cartService.getCartById(cartId);
    	model.addAttribute("cartId", cartId);
    	model.addAttribute("grandTotal", cart.getGrandTotal());

        if (result.hasErrors()) {
            return "cardDetailError";
        }

       
       
        cartItemService.removeAllCartItems(cart);
        cardDetail.setUsersDetail(userdetails);
        cardDetail.setCart(cart);
        cardDetail.setTotalCost(cart.getGrandTotal());
        cardService.addCardDetail(cardDetail);

        return "orderCompleted";

    }

}
