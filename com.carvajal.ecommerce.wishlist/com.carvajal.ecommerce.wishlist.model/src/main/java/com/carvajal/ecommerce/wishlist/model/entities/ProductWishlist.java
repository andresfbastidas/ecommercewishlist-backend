package com.carvajal.ecommerce.wishlist.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the product_wishlist database table.
 * 
 */
@Entity
@Table(name="product_wishlist")
@NamedQuery(name="ProductWishlist.findAll", query="SELECT p FROM ProductWishlist p")
public class ProductWishlist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_WISHLIST_IDPRODUCTWISHLIST_GENERATOR", sequenceName="PRODUCT_WISHLIST_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_WISHLIST_IDPRODUCTWISHLIST_GENERATOR")
	@Column(name="id_product_wishlist")
	private Long idProductWishlist;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to Wishlist
	@ManyToOne
	@JoinColumn(name="id_wish_list")
	private Wishlist wishlist;

	//bi-directional many-to-one association to Wishlisthistory
	@OneToMany(mappedBy="productWishlist")
	private List<Wishlisthistory> wishlisthistories;

	public ProductWishlist() {
	}

	public Long getIdProductWishlist() {
		return this.idProductWishlist;
	}

	public void setIdProductWishlist(Long idProductWishlist) {
		this.idProductWishlist = idProductWishlist;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Wishlist getWishlist() {
		return this.wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public List<Wishlisthistory> getWishlisthistories() {
		return this.wishlisthistories;
	}

	public void setWishlisthistories(List<Wishlisthistory> wishlisthistories) {
		this.wishlisthistories = wishlisthistories;
	}

	public Wishlisthistory addWishlisthistory(Wishlisthistory wishlisthistory) {
		getWishlisthistories().add(wishlisthistory);
		wishlisthistory.setProductWishlist(this);

		return wishlisthistory;
	}

	public Wishlisthistory removeWishlisthistory(Wishlisthistory wishlisthistory) {
		getWishlisthistories().remove(wishlisthistory);
		wishlisthistory.setProductWishlist(null);

		return wishlisthistory;
	}

}