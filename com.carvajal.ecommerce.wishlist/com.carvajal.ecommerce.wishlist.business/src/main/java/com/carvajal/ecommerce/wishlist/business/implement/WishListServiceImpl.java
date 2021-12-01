package com.carvajal.ecommerce.wishlist.business.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carvajal.ecommerce.wishlist.model.constant.KeyConstants;
import com.carvajal.ecommerce.wishlist.model.entities.Product;
import com.carvajal.ecommerce.wishlist.model.entities.Userapp;
import com.carvajal.ecommerce.wishlist.model.entities.Wishlist;
import com.carvajal.ecommerce.wishlist.model.entities.Wishlisthistory;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.model.request.AddWishListRequest;
import com.carvajal.ecommerce.wishlist.persistence.WishListHistoryRepository;
import com.carvajal.ecommerce.wishlist.persistence.WishListRepository;

@Service
public class WishListServiceImpl {

	@Autowired
	private WishListRepository wishListRepository;

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private WishListHistoryRepository wishListHistoryRepository;

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addProductWishList(AddWishListRequest addWishListRequest) throws EcommerceException {

		try {
			Wishlist wishlist = wishListRepository.findByProductId(addWishListRequest.getIdProduct());
			if(wishlist != null) {
				throw new EcommerceException(KeyConstants.ERROR_CODE_WISH_LIST,
						KeyConstants.PRODUCT_EXISTS_WISH_LIST, KeyConstants.TECHNICAL_ERROR_LISTA_DE_DESEOS);
			}else {
				wishlist = new Wishlist();
				Product product = productServiceImpl.findByProductId(addWishListRequest.getIdProduct());
				Userapp user = userDetailsServiceImpl.findByUserName(addWishListRequest.getUserName());
				//wishlist.setNameWishlist(addWishListRequest.getWishlist().getNameWishlist());
				wishlist.setProduct(product);
				wishlist.setUserapp(user);
				wishListRepository.save(wishlist);

				Wishlisthistory wishlisthistory = new Wishlisthistory();
				wishlisthistory.setIdProduct(addWishListRequest.getIdProduct());
				wishlisthistory.setIdUserApp(user.getIdUserApp());
				//wishlisthistory.setNameWishlist(addWishListRequest.getWishlist().getNameWishlist());
				wishListHistoryRepository.save(wishlisthistory);
			}
		
		} catch (Exception e) {
			throw e;
		}
	}

}
