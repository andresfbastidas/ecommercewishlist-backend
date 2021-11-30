package com.carvajal.ecommerce.wishlist.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the userapp database table.
 * 
 */
@Entity
@NamedQuery(name = "Userapp.findAll", query = "SELECT u FROM Userapp u")
public class Userapp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USERAPP_IDUSERAPP_GENERATOR", sequenceName = "USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERAPP_IDUSERAPP_GENERATOR")
	@Column(name = "id_user_app")
	private Long idUserApp;

	@Column(name = "email")
	private String email;

	@Column(name = "firts_name")
	private String firtsName;

	@Column(name = "second_name")
	private String secondName;

	@Column(name = "second_surname")
	private String secondSurname;

	@Column(name = "surname")
	private String surname;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	// bi-directional many-to-one association to ProductUserapp
	@OneToMany(mappedBy = "userapp")
	private List<ProductUserapp> productUserapps;

	// bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name = "profile_id")
	private Profile profile;

	public Userapp() {
	}

	public Long getIdUserApp() {
		return this.idUserApp;
	}

	public void setIdUserApp(Long idUserApp) {
		this.idUserApp = idUserApp;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirtsName() {
		return this.firtsName;
	}

	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}

	public String getSecondName() {
		return this.secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSecondSurname() {
		return this.secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<ProductUserapp> getProductUserapps() {
		return this.productUserapps;
	}

	public void setProductUserapps(List<ProductUserapp> productUserapps) {
		this.productUserapps = productUserapps;
	}

	public ProductUserapp addProductUserapp(ProductUserapp productUserapp) {
		getProductUserapps().add(productUserapp);
		productUserapp.setUserapp(this);

		return productUserapp;
	}

	public ProductUserapp removeProductUserapp(ProductUserapp productUserapp) {
		getProductUserapps().remove(productUserapp);
		productUserapp.setUserapp(null);

		return productUserapp;
	}

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}