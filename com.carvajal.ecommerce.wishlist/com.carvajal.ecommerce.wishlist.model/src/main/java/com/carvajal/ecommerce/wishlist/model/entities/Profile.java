package com.carvajal.ecommerce.wishlist.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the profile database table.
 * 
 */
@Entity
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PROFILE_PROFILEID_GENERATOR", sequenceName="PROFILE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROFILE_PROFILEID_GENERATOR")
	@Column(name="profile_id")
	private Long profileId;

	@Column(name="profile_name")
	private String profileName;

	//bi-directional many-to-one association to Userapp
	@OneToMany(mappedBy="profile")
	private List<Userapp> userapps;

	public Profile() {
	}

	public Long getProfileId() {
		return this.profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return this.profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public List<Userapp> getUserapps() {
		return this.userapps;
	}

	public void setUserapps(List<Userapp> userapps) {
		this.userapps = userapps;
	}

	public Userapp addUserapp(Userapp userapp) {
		getUserapps().add(userapp);
		userapp.setProfile(this);

		return userapp;
	}

	public Userapp removeUserapp(Userapp userapp) {
		getUserapps().remove(userapp);
		userapp.setProfile(null);

		return userapp;
	}

}