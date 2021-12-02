package com.carvajal.ecommerce.wishlist.business.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.carvajal.ecommerce.wishlist.business.utils.ServiceUtils;
import com.carvajal.ecommerce.wishlist.model.constant.KeyConstants;
import com.carvajal.ecommerce.wishlist.model.entities.Product;
import com.carvajal.ecommerce.wishlist.model.entities.Userapp;
import com.carvajal.ecommerce.wishlist.model.entities.Wishlist;
import com.carvajal.ecommerce.wishlist.model.entities.Wishlisthistory;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.model.request.WishListRequest;
import com.carvajal.ecommerce.wishlist.persistence.WishListHistoryRepository;
import com.carvajal.ecommerce.wishlist.persistence.WishListRepository;

@Service
public class WishListServiceImpl extends ServiceUtils {

	@Autowired
	private WishListRepository wishListRepository;

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	private WishListHistoryRepository wishListHistoryRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	private static final String CLASS_NAME = "WishListServiceImpl";

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addProductWishList(WishListRequest wishListRequest) throws EcommerceException {

		try {
			Wishlist wishlist = wishListRepository.findByProductId(wishListRequest.getIdProduct());
			if (wishlist != null) {
				buildCustomException(KeyConstants.PRODUCT_EXISTS_WISH_LIST, KeyConstants.ERROR_CODE_WISH_LIST);
			} else {
				wishlist = new Wishlist();
				Product product = productServiceImpl.findByProductId(wishListRequest.getIdProduct());
				Userapp user = userDetailsServiceImpl.findByUserName(wishListRequest.getUserName());
				// wishlist.setNameWishlist(addWishListRequest.getWishlist().getNameWishlist());
				wishlist.setProduct(product);
				wishlist.setUserapp(user);
				wishListRepository.save(wishlist);

				Wishlisthistory wishlisthistory = new Wishlisthistory();
				wishlisthistory.setIdProduct(wishListRequest.getIdProduct());
				wishlisthistory.setIdUserApp(user.getIdUserApp());
				// wishlisthistory.setNameWishlist(addWishListRequest.getWishlist().getNameWishlist());
				wishListHistoryRepository.save(wishlisthistory);
			}

		} catch (EcommerceException e) {
			throw e;
		}catch (Exception e) {
			LOGGER.error(KeyConstants.ERROR_INESPERADO_APP, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
	}

	@Transactional(readOnly = true)
	public List<Wishlist> findAllWishList() throws EcommerceException {
		List<Wishlist> wishLists = null;
		try {
			wishLists = wishListRepository.findAll();
			if (wishLists.isEmpty() || wishLists.equals(null)) {
				buildCustomException(KeyConstants.WISH_LIST_IS_EMPTY, KeyConstants.ERROR_CODE_WISH_LIST);
			} else {
				for (Wishlist wishlist : wishLists) {
					try {
						if (wishlist.getProduct().getProductQuantity() == 0) {
							buildCustomException(KeyConstants.PRODUCT_STOCK_EMPTY, KeyConstants.ERROR_CODE_WISH_LIST);
						}
					} catch (Exception e) {
						continue;
					}

				}
			}
		} catch (EcommerceException e) {
			throw e;
		}catch (Exception e) {
			LOGGER.error(KeyConstants.ERROR_INESPERADO_APP, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

		return wishLists;
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteByProductId(WishListRequest addWishListRequest) throws EcommerceException {

		try {
			Wishlist wishlist = wishListRepository.findByProductId(addWishListRequest.getIdProduct());
			if (wishlist != null) {
				wishListRepository.deleteByProduct(addWishListRequest.getIdProduct());
			} else {
				buildCustomException(KeyConstants.PRODUCT_NOT_FOUND_WISH_LIST, KeyConstants.ERROR_CODE_WISH_LIST);
			}

		} catch (EcommerceException e) {
			throw e;
		}catch (Exception e) {
			LOGGER.error(KeyConstants.ERROR_INESPERADO_APP, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}
	}

}
