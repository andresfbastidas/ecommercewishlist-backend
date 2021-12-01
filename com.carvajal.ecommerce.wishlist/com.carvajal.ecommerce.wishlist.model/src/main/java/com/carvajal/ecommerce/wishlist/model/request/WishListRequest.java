package com.carvajal.ecommerce.wishlist.model.request;

import java.io.Serializable;

public class WishListRequest implements Serializable {

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

	private static final long serialVersionUID = 1620339585946365030L;

}
