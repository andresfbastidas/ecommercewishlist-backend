package com.carvajal.ecommerce.wishlist.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;


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

	//bi-directional many-to-one association to ProductWishlist
	@OneToMany(mappedBy="product")
	@JsonIgnore
	private List<ProductWishlist> productWishlists;

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

	public List<ProductWishlist> getProductWishlists() {
		return this.productWishlists;
	}

	public void setProductWishlists(List<ProductWishlist> productWishlists) {
		this.productWishlists = productWishlists;
	}

	public ProductWishlist addProductWishlist(ProductWishlist productWishlist) {
		getProductWishlists().add(productWishlist);
		productWishlist.setProduct(this);

		return productWishlist;
	}

	public ProductWishlist removeProductWishlist(ProductWishlist productWishlist) {
		getProductWishlists().remove(productWishlist);
		productWishlist.setProduct(null);

		return productWishlist;
	}

}