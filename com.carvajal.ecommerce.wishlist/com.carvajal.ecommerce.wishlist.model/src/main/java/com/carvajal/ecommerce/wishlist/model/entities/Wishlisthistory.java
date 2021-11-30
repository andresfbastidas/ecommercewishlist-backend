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

	@Column(name="id_product")
	private Long idProduct;

	@Column(name="id_user_app")
	private Long idUserApp;

	@Column(name="name_wishlist")
	private String nameWishlist;

	//bi-directional many-to-one association to Wishlist
	@ManyToOne
	@JoinColumn(name="id_wish_list")
	private Wishlist wishlist;

	public Wishlisthistory() {
	}

	public Long getIdWishListHistory() {
		return this.idWishListHistory;
	}

	public void setIdWishListHistory(Long idWishListHistory) {
		this.idWishListHistory = idWishListHistory;
	}

	public Long getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Long getIdUserApp() {
		return this.idUserApp;
	}

	public void setIdUserApp(Long idUserApp) {
		this.idUserApp = idUserApp;
	}

	public String getNameWishlist() {
		return this.nameWishlist;
	}

	public void setNameWishlist(String nameWishlist) {
		this.nameWishlist = nameWishlist;
	}

	public Wishlist getWishlist() {
		return this.wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

}