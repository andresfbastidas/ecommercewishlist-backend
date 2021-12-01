package com.carvajal.ecommerce.wishlist.model.response;

import java.io.Serializable;
import java.util.List;

import com.carvajal.ecommerce.wishlist.model.entities.Wishlist;

public class AllProductsWishListResponse implements Serializable {

	private List<Wishlist> wishlists;

	public List<Wishlist> getWishlists() {
		return wishlists;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	private static final long serialVersionUID = -8631838444061504966L;

}
