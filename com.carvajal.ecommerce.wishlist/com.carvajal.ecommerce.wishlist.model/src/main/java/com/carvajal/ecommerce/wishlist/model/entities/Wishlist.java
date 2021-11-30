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

	//bi-directional many-to-one association to ProductWishlist
	@OneToMany(mappedBy="wishlist")
	private List<ProductWishlist> productWishlists;

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

	public List<ProductWishlist> getProductWishlists() {
		return this.productWishlists;
	}

	public void setProductWishlists(List<ProductWishlist> productWishlists) {
		this.productWishlists = productWishlists;
	}

	public ProductWishlist addProductWishlist(ProductWishlist productWishlist) {
		getProductWishlists().add(productWishlist);
		productWishlist.setWishlist(this);

		return productWishlist;
	}

	public ProductWishlist removeProductWishlist(ProductWishlist productWishlist) {
		getProductWishlists().remove(productWishlist);
		productWishlist.setWishlist(null);

		return productWishlist;
	}

}