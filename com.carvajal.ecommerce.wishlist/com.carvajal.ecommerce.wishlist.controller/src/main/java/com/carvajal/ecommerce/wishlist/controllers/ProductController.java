package com.carvajal.ecommerce.wishlist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.ecommerce.wishlist.business.implement.ProductServiceImpl;
import com.carvajal.ecommerce.wishlist.controller.constant.FcdConstants;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.model.response.ProductResponse;

@RestController
@RequestMapping(path = FcdConstants.PRODUCT)
public class ProductController {
	
	@Autowired
    private ProductServiceImpl productServiceImpl;
	
	@GetMapping(FcdConstants.FIND_ALL_PRODUCTS)
	public ResponseEntity<?> findAllProducts() throws EcommerceException{
		ProductResponse productResponse = new ProductResponse();
		productResponse.setProductList(productServiceImpl.findAll());
		return new ResponseEntity<>(productResponse, HttpStatus.OK);
		
	}

}
