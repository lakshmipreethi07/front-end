package com.niit.shopping.model;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;


@Component
@Entity
public class Cart implements Serializable {

    private static final long serialVersionUID = 13L;

    @Id
    @GeneratedValue
    private int cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cartitem> cartItems;

    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private Userdetails usersDetail;

   

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private double grandTotal;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public List<Cartitem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Cartitem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
    
    public Userdetails getUsersDetail() {
		return usersDetail;
	}

	public void setUsersDetail(Userdetails usersDetail) {
		this.usersDetail = usersDetail;
	}
}
