package com.carvajal.ecommerce.wishlist.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carvajal.ecommerce.wishlist.model.entities.Userapp;

@Repository
public interface UserAppRepository extends JpaRepository<Userapp, Long> {

	public Userapp findByUserName(String userName);

	Boolean existsByUserName(String userName);
}
