package com.carvajal.ecommerce.wishlist.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the userapp database table.
 * 
 */
@Entity
@NamedQuery(name="Userapp.findAll", query="SELECT u FROM Userapp u")
public class Userapp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERAPP_IDUSERAPP_GENERATOR", sequenceName="USER_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERAPP_IDUSERAPP_GENERATOR")
	@Column(name="id_user_app")
	private Long idUserApp;

	private String email;

	@Column(name="firts_name")
	private String firtsName;

	private String password;

	@Column(name="second_name")
	private String secondName;

	@Column(name="second_surname")
	private String secondSurname;

	private String surname;

	@Column(name="user_name")
	private String userName;

	//bi-directional many-to-one association to Profile
	@ManyToOne
	@JoinColumn(name="profile_id")
	private Profile profile;

	//bi-directional many-to-one association to Wishlist
	@OneToMany(mappedBy="userapp")
	private List<Wishlist> wishlists;

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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Profile getProfile() {
		return this.profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Wishlist> getWishlists() {
		return this.wishlists;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	public Wishlist addWishlist(Wishlist wishlist) {
		getWishlists().add(wishlist);
		wishlist.setUserapp(this);

		return wishlist;
	}

	public Wishlist removeWishlist(Wishlist wishlist) {
		getWishlists().remove(wishlist);
		wishlist.setUserapp(null);

		return wishlist;
	}

}