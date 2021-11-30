package com.carvajal.ecommerce.wishlist.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the wishlist database table.
 * 
 */
@Entity
@NamedQuery(name="Wishlist.findAll", query="SELECT w FROM Wishlist w")
public class Wishlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="WISHLIST_IDWISHLIST_GENERATOR", sequenceName="WISHLIST_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WISHLIST_IDWISHLIST_GENERATOR")
	@Column(name="id_wish_list")
	private Long idWishList;

	@Column(name="name_wishlist")
	private String nameWishlist;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to Userapp
	@ManyToOne
	@JoinColumn(name="id_user_app")
	private Userapp userapp;

	//bi-directional many-to-one association to Wishlisthistory
	@OneToMany(mappedBy="wishlist")
	private List<Wishlisthistory> wishlisthistories;

	public Wishlist() {
	}

	public Long getIdWishList() {
		return this.idWishList;
	}

	public void setIdWishList(Long idWishList) {
		this.idWishList = idWishList;
	}

	public String getNameWishlist() {
		return this.nameWishlist;
	}

	public void setNameWishlist(String nameWishlist) {
		this.nameWishlist = nameWishlist;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Userapp getUserapp() {
		return this.userapp;
	}

	public void setUserapp(Userapp userapp) {
		this.userapp = userapp;
	}

	public List<Wishlisthistory> getWishlisthistories() {
		return this.wishlisthistories;
	}

	public void setWishlisthistories(List<Wishlisthistory> wishlisthistories) {
		this.wishlisthistories = wishlisthistories;
	}

	public Wishlisthistory addWishlisthistory(Wishlisthistory wishlisthistory) {
		getWishlisthistories().add(wishlisthistory);
		wishlisthistory.setWishlist(this);

		return wishlisthistory;
	}

	public Wishlisthistory removeWishlisthistory(Wishlisthistory wishlisthistory) {
		getWishlisthistories().remove(wishlisthistory);
		wishlisthistory.setWishlist(null);

		return wishlisthistory;
	}

}