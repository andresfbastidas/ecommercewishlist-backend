package com.carvajal.ecommerce.wishlist.business.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carvajal.ecommerce.wishlist.model.constant.KeyConstants;
import com.carvajal.ecommerce.wishlist.model.entities.Product;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.persistence.ProductRepository;

@Service
public class ProductServiceImpl {

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<Product> findAll() throws EcommerceException {
		List<Product> productList = null;
		try {
			productList = productRepository.findAll();
			if (productList.isEmpty() || productList.equals(null)) {
				throw new EcommerceException(KeyConstants.ERROR_CODE_PRODUCTS_NOT_FOUND,
						KeyConstants.PRODUCTS_NOT_FOUND, KeyConstants.TECHNICAL_ERROR_PRODUCTS);
			}
		} catch (Exception e) {
			throw e;
		}

		return productList;
	}

	@Transactional(readOnly = true)
	public Product findByProductId(Long productId) throws EcommerceException {
		Product product = null;
		try {
			product = productRepository.findByProductId(productId);
			if (product == null) {
				throw new EcommerceException(KeyConstants.ERROR_CODE_PRODUCTS_NOT_FOUND,
						KeyConstants.PRODUCT_NOT_FOUND, KeyConstants.TECHNICAL_ERROR_PRODUCTS);
			}
		} catch (Exception e) {
			throw e;
		}

		return product;
	}

}
