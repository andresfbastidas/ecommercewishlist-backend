package com.carvajal.ecommerce.wishlist.model.response;

import java.io.Serializable;
import java.util.List;

import com.carvajal.ecommerce.wishlist.model.entities.Product;

public class ProductResponse implements Serializable {

	List<Product> productList;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	private static final long serialVersionUID = -1753568271684091558L;

}
