package com.carvajal.ecommerce.wishlist.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carvajal.ecommerce.wishlist.model.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	public List<Product> findAll();
	
	@Query(value = "select * from Product p where p.id_product=?1", nativeQuery = true)
	public Product findByProductId(Long idProduct);

}
