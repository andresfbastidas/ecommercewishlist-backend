package com.carvajal.ecommerce.wishlist.model.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the product database table.
 * 
 */
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_IDPRODUCT_GENERATOR", sequenceName="PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_IDPRODUCT_GENERATOR")
	@Column(name="id_product")
	private Long idProduct;

	@Column(name="price")
	private Long price;

	@Column(name="product_name")
	private String productName;

	@Column(name="product_quantity")
	private Long productQuantity;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="id_category")
	@JsonIgnore
	private Category category;

	//bi-directional many-to-one association to ProductUserapp
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<ProductUserapp> productUserapps;

	//bi-directional many-to-one association to Wishlist
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<Wishlist> wishlists;

	public Product() {
	}

	public Long getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public Long getPrice() {
		return this.price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(Long productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<ProductUserapp> getProductUserapps() {
		return this.productUserapps;
	}

	public void setProductUserapps(List<ProductUserapp> productUserapps) {
		this.productUserapps = productUserapps;
	}

	public ProductUserapp addProductUserapp(ProductUserapp productUserapp) {
		getProductUserapps().add(productUserapp);
		productUserapp.setProduct(this);

		return productUserapp;
	}

	public ProductUserapp removeProductUserapp(ProductUserapp productUserapp) {
		getProductUserapps().remove(productUserapp);
		productUserapp.setProduct(null);

		return productUserapp;
	}

	public List<Wishlist> getWishlists() {
		return this.wishlists;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	public Wishlist addWishlist(Wishlist wishlist) {
		getWishlists().add(wishlist);
		wishlist.setProduct(this);

		return wishlist;
	}

	public Wishlist removeWishlist(Wishlist wishlist) {
		getWishlists().remove(wishlist);
		wishlist.setProduct(null);

		return wishlist;
	}

}