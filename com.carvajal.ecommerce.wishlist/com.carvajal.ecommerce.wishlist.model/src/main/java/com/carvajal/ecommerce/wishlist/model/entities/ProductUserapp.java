package com.carvajal.ecommerce.wishlist.model.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the product_userapp database table.
 * 
 */
@Entity
@Table(name="product_userapp")
@NamedQuery(name="ProductUserapp.findAll", query="SELECT p FROM ProductUserapp p")
public class ProductUserapp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_USERAPP_IDPRODUCTUSERAPP_GENERATOR", sequenceName="USER_PRODUCT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_USERAPP_IDPRODUCTUSERAPP_GENERATOR")
	@Column(name="id_product_user_app")
	private Long idProductUserApp;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to Userapp
	@ManyToOne
	@JoinColumn(name="id_user_app")
	private Userapp userapp;

	public ProductUserapp() {
	}

	public Long getIdProductUserApp() {
		return this.idProductUserApp;
	}

	public void setIdProductUserApp(Long idProductUserApp) {
		this.idProductUserApp = idProductUserApp;
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

}