package com.carvajal.ecommerce.wishlist.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.ecommerce.wishlist.business.implement.WishListServiceImpl;
import com.carvajal.ecommerce.wishlist.controller.constant.FcdConstants;
import com.carvajal.ecommerce.wishlist.model.constant.KeyConstants;
import com.carvajal.ecommerce.wishlist.model.entities.Wishlist;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.model.request.AddWishListRequest;
import com.carvajal.ecommerce.wishlist.model.response.AllProductsWishListResponse;
import com.carvajal.ecommerce.wishlist.model.response.GenericResponse;

@RestController
@RequestMapping(path = FcdConstants.WISH_LIST)
public class WishListController {

	@Autowired
	private WishListServiceImpl wishListServiceImpl;

	@PostMapping(FcdConstants.ADD_PRODUCT_WISH_LIST)
	public ResponseEntity<?> registerUser(@Valid @RequestBody AddWishListRequest addWishListRequest)
			throws EcommerceException {

		wishListServiceImpl.addProductWishList(addWishListRequest);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.SUCCESS_ADD_PRODUCT_WISHLIST);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

	@GetMapping(FcdConstants.FIND_ALL_WISH_LIST)
	public ResponseEntity<?> findAllProducts() throws EcommerceException {
		List<Wishlist> wishlists = wishListServiceImpl.findAllWishList();

		AllProductsWishListResponse allProductsWishListResponse = new AllProductsWishListResponse();
		allProductsWishListResponse.setWishlists(wishlists);
		return new ResponseEntity<>(allProductsWishListResponse, HttpStatus.OK);

	}
}
