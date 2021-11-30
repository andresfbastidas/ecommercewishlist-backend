package com.carvajal.ecommerce.wishlist.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carvajal.ecommerce.wishlist.model.entities.Product;
import com.carvajal.ecommerce.wishlist.model.entities.Userapp;
import com.carvajal.ecommerce.wishlist.model.entities.Wishlist;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.model.request.AddWishListRequest;
import com.carvajal.ecommerce.wishlist.persistence.WishListRepository;

@Service
public class WishListServiceImpl {

	@Autowired
	WishListRepository wishListRepository;

	@Autowired
	ProductServiceImpl productServiceImpl;

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	public void addProductWishList(AddWishListRequest addWishListRequest) throws EcommerceException {

		try {
			Wishlist wishlist = new Wishlist();
			Product product = productServiceImpl.findByProductId(addWishListRequest.getIdProduct());
			Userapp user = userDetailsServiceImpl.findByUserName(addWishListRequest.getUserName());
			wishlist.setNameWishlist(addWishListRequest.getWishlist().getNameWishlist());
			wishlist.setIdWishList(addWishListRequest.getWishlist().getIdWishList());
			wishlist.setProduct(product);
			wishlist.setUserapp(user);
			wishListRepository.save(wishlist);
		} catch (Exception e) {
			throw e;
		}
	}

}
