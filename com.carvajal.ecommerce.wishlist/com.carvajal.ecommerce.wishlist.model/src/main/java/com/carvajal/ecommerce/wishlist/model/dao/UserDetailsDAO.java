package com.carvajal.ecommerce.wishlist.model.dao;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.carvajal.ecommerce.wishlist.model.entities.Userapp;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsDAO implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String userName;

	private String email;

	@JsonIgnore
	private String password;

	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsDAO(Long id, String userName, String email, String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsDAO build(Userapp user) {
		List<GrantedAuthority> authorities = user.getProfile().getUserapps().stream()
				.map(profile -> new SimpleGrantedAuthority(profile.getProfile().getProfileName()))
				.collect(Collectors.toList());

		return new UserDetailsDAO(user.getIdUserApp(), user.getUserName(), user.getEmail(), user.getPassword(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsDAO user = (UserDetailsDAO) o;
		return Objects.equals(id, user.id);
	}
}
