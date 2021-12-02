package com.carvajal.ecommerce.wishlist.business.implement;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvajal.ecommerce.wishlist.business.utils.ServiceUtils;
import com.carvajal.ecommerce.wishlist.model.constant.KeyConstants;
import com.carvajal.ecommerce.wishlist.model.entities.Product;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.persistence.ProductRepository;

@Service
public class ProductServiceImpl extends ServiceUtils {

	@Autowired
	private ProductRepository productRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	private static final String CLASS_NAME = "ProductServiceImpl";


	@Transactional(readOnly = true)
	public List<Product> findAll() throws EcommerceException {
		List<Product> productList = null;
		try {
			productList = productRepository.findAll();
			if (productList.isEmpty() || productList.equals(null)) {
				buildCustomException(KeyConstants.PRODUCTS_NOT_FOUND, KeyConstants.ERROR_CODE_PRODUCTS_NOT_FOUND);
			}
		} catch (EcommerceException e) {
			throw e;
		}catch (Exception e) {
			LOGGER.error(KeyConstants.ERROR_INESPERADO_APP, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}


		return productList;
	}

	@Transactional(readOnly = true)
	public Product findByProductId(Long productId) throws EcommerceException {
		Product product = null;
		try {
			product = productRepository.findByProductId(productId);
			if (product == null) {
				buildCustomException(KeyConstants.PRODUCT_NOT_FOUND, KeyConstants.ERROR_CODE_PRODUCTS_NOT_FOUND);
			}
		} catch (EcommerceException e) {
			throw e;
		}catch (Exception e) {
			LOGGER.error(KeyConstants.ERROR_INESPERADO_APP, e);
			callCustomException(KeyConstants.COMMON_ERROR, e, CLASS_NAME);
		}

		return product;
	}

}
