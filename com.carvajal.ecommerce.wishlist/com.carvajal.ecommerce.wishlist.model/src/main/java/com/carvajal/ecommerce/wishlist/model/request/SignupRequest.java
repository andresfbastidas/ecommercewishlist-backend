package com.carvajal.ecommerce.wishlist.model.request;

import java.io.Serializable;

import javax.validation.constraints.Size;

public class SignupRequest implements Serializable {

	@Size(min = 3, max = 20)
	private String username;

	@Size(max = 50)
	private String email;

	private Long idProfile;

	@Size(min = 6, max = 40)
	private String password;

	private String firstName;

	private String surname;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Long idProfile) {
		this.idProfile = idProfile;
	}
	
	private static final long serialVersionUID = -486180400748210308L;

}
