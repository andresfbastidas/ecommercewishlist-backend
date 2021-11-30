package com.carvajal.ecommerce.wishlist.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the wishlisthistory database table.
 * 
 */
@Entity
@NamedQuery(name="Wishlisthistory.findAll", query="SELECT w FROM Wishlisthistory w")
public class Wishlisthistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WISHLISTHISTORY_IDWISHLISTHISTORY_GENERATOR", sequenceName="WISHLISTHISTORY_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WISHLISTHISTORY_IDWISHLISTHISTORY_GENERATOR")
	@Column(name="id_wish_list_history")
	private Long idWishListHistory;

	//bi-directional many-to-one association to ProductWishlist
	@ManyToOne
	@JoinColumn(name="id_product_wishlist")
	private ProductWishlist productWishlist;

	public Wishlisthistory() {
	}

	public Long getIdWishListHistory() {
		return this.idWishListHistory;
	}

	public void setIdWishListHistory(Long idWishListHistory) {
		this.idWishListHistory = idWishListHistory;
	}

	public ProductWishlist getProductWishlist() {
		return this.productWishlist;
	}

	public void setProductWishlist(ProductWishlist productWishlist) {
		this.productWishlist = productWishlist;
	}

}