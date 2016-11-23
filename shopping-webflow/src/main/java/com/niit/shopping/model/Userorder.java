package com.niit.shopping.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Userorder implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue
    private int userOrderId;
	
	@OneToOne
    @JoinColumn(name = "cartId")
    @JsonIgnore
    private Cart cart;

	public int getUserOrderId() {
		return userOrderId;
	}

	public void setUserOrderId(int userOrderId) {
		this.userOrderId = userOrderId;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	@OneToOne
	@JoinColumn(name="userid")
	private Userdetails userdetails;

	public Userdetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(Userdetails userdetails) {
		this.userdetails = userdetails;
	}
	
		
	
	
	
	
	
}
