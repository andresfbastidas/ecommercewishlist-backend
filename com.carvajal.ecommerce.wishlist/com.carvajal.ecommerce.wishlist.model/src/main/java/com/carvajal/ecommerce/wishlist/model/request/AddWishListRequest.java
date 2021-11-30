package com.carvajal.ecommerce.wishlist.model.request;

import java.io.Serializable;

import com.carvajal.ecommerce.wishlist.model.entities.Wishlist;

public class AddWishListRequest implements Serializable {

	private Wishlist wishlist;

	private Long idProduct;

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	private static final long serialVersionUID = 1620339585946365030L;

}
