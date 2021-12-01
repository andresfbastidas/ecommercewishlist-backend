package com.carvajal.ecommerce.wishlist.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carvajal.ecommerce.wishlist.model.entities.Wishlist;

@Repository
public interface WishListRepository extends JpaRepository<Wishlist, Long> {

	@Query(value = "select * from wishlist where id_product = ?1", nativeQuery = true)
	public Wishlist findByProductId(Long idProduct);
	
	public List<Wishlist> findAll();
}
