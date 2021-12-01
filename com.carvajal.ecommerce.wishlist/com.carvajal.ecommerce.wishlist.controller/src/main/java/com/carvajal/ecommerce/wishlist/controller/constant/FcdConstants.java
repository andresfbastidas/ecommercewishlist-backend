package com.carvajal.ecommerce.wishlist.controller.constant;

public class FcdConstants {

	private static final String VERSION_API = "1.0";

	public static final String CONTEXT_API = "/api/" + VERSION_API;

	public static final String USER = CONTEXT_API + "/user";
	
	public static final String PRODUCT = CONTEXT_API + "/product";
	
	public static final String WISH_LIST = CONTEXT_API + "/wishList";

	public static final String LOGIN = "/authenticate";

	public static final String CREATE_USER = "/createUser";
	
	public static final String FIND_ALL_PRODUCTS = "/findAllProducts";
	
	public static final String ADD_PRODUCT_WISH_LIST = "/addProductWishList";
	
	public static final String FIND_ALL_WISH_LIST = "/allProductsWishList";
	
	public static final String DELETE_PRODUCT_WISH_LIST = "/deleteProductById";

}
