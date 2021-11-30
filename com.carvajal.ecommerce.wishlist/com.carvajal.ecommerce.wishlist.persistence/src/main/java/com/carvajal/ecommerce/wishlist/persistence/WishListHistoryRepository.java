package com.carvajal.ecommerce.wishlist.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvajal.ecommerce.wishlist.model.entities.Wishlisthistory;

@Repository
public interface WishListHistoryRepository extends JpaRepository<Wishlisthistory, Long> {

}
