package com.niit.shopping.controller;




import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.niit.shopping.dao.BillingAddressDAO;
import com.niit.shopping.dao.CartDAO;
import com.niit.shopping.dao.CartItemDAO;
import com.niit.shopping.dao.ShippingAddressDAO;
import com.niit.shopping.dao.UserdetailsDAO;
import com.niit.shopping.model.BillingAddress;
import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Product;
import com.niit.shopping.model.ShippingAddress;
import com.niit.shopping.model.Userdetails;

@Component
public class FlowController {
	
	@Autowired
	private ShippingAddress shippingAddress;

	@Autowired
	private BillingAddress billingAddress;
	/*@Autowired
	private CardDetail cardDetail;*/

	@Autowired
	private ShippingAddressDAO shippingAddressDAO;

	@Autowired
	private BillingAddressDAO billingAddressDAO;
	/*@Autowired
	private CardDetailDAO cardDetailDAO;*/
	@Autowired
	Userdetails userdetails;
	@Autowired
	UserdetailsDAO userdetailsDAO;

	@Autowired
	CartDAO cartDAO;

	@Autowired
	Cart cart;
	 /*@Autowired
	    private SessionFactory sessionFactory;

	    @Autowired
	    private OrderDao orderdao;*/
	@Autowired
	CartItemDAO cartItemDAO;
	@Autowired
	HttpSession httpSession;
	@Autowired
	Product product;
	
	/* public Cart validate(int cartId) throws IOException {
	        Cart cart=getCartById(cartId);
	        if(cart==null||cart.getCartItems().size()==0) {
	            throw new IOException(cartId+"");
	        }
	        update(cart);
	        return cart;
	    }
	 public Cart getCartById (int cartId) {
	        Session session = sessionFactory.getCurrentSession();
	        return (Cart) session.get(Cart.class, cartId);
	    }

	    public void update(Cart cart) {
	        int cartId = cart.getCartId();
	        double grandTotal = orderdao.getOrderGrandTotal(cartId);
	        cart.setGrandTotal(grandTotal);

	        Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(cart);
	    }*/
	public String addShippingAddress(ShippingAddress shippingAddress) {
		userdetails = userdetailsDAO.getUserByUsername(SecurityContextHolder.getContext()
				.getAuthentication().getName());

		shippingAddress.setUserid(userdetails.getUserid());
		//checkoutDetails.setShippingAddress(shippingAddress);

		this.shippingAddress.setUserid(userdetails.getUserid());
		this.shippingAddress.setLine1(shippingAddress.getLine1());
		this.shippingAddress.setLine2(shippingAddress.getLine2());
		this.shippingAddress.setCity(shippingAddress.getCity());
		this.shippingAddress.setState(shippingAddress.getState());
		this.shippingAddress.setCountry(shippingAddress.getCountry());
		this.shippingAddress.setZipCode(shippingAddress.getZipCode());
		shippingAddressDAO.saveOrUpdate(shippingAddress);
		return "success";
	}

	public String addBillingAddress( BillingAddress billingAddress) {
		userdetails = userdetailsDAO.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
		billingAddress.setUserid(userdetails.getUserid());
		//checkoutDetails.setBillingAddress(billingAddress);

		this.billingAddress.setUserid(userdetails.getUserid());
		this.billingAddress.setLine1(billingAddress.getLine1());
		this.billingAddress.setLine2(billingAddress.getLine2());
		this.billingAddress.setCity(billingAddress.getCity());
		this.billingAddress.setState(billingAddress.getState());
		this.billingAddress.setCountry(billingAddress.getCountry());
		this.billingAddress.setZipCode(billingAddress.getZipCode());
		billingAddressDAO.saveOrUpdate(billingAddress);
		return "success";
	}

	/*public String addCardDetails(CardDetail cardDetail) {
		userdetails = userdetailsDAO.getCustomerByUserName(SecurityContextHolder.getContext().getAuthentication().getName());

		cardDetail.setUserid(userdetails.getUserid());
		cardDetail.setTotalCost(cartDAO.getCartById(userdetails.getUserid()).getGrandTotal());
		cardDetailDAO.saveOrUpdate(cardDetail);

		List<CartItem> listOfCartItems = cartItemDAO.getCartItemByItemId(userdetails.getUserid());

		listOfCartItems = cartItemDAO.getCartItemsByCustomerId(userdetails.getUserid());

		cart = cartDAO.getCartById(userdetails.getUserid());

		cart.setCartId(cart.getCartId());
		cart.setCustomerId(cart.getUserdetails());
		cart.setNoOfProducts(listOfCartItems.size());

		shippingAddressDAO.saveOrUpdate(checkoutDetails.getShippingAddress());
		billingAddressDAO.saveOrUpdate(checkoutDetails.getBillingAddress());
		cartDAO.update(cart);

		httpSession.setAttribute("noOfProducts", cart.getNoOfProducts());

		return "success";
	}

	*/
	

}
