package com.carvajal.ecommerce.wishlist.business.implement;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carvajal.ecommerce.wishlist.model.constant.KeyConstants;
import com.carvajal.ecommerce.wishlist.model.dao.UserDetailsDAO;
import com.carvajal.ecommerce.wishlist.model.entities.Profile;
import com.carvajal.ecommerce.wishlist.model.entities.Userapp;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.model.request.SignupRequest;
import com.carvajal.ecommerce.wishlist.persistence.UserAppRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserAppRepository userAppRepository;

	@Autowired
	PasswordEncoder encoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Userapp user = null;
		try {
			user = userAppRepository.findByUserName(userName);
			if (user == null) {
				throw new UsernameNotFoundException(KeyConstants.USER_NOT_FOUND);
			}
		} catch (UsernameNotFoundException e) {
			throw e;
		}

		return UserDetailsDAO.build(user);
	}

	@Transactional
	public Userapp findByUserName(String userName) throws EcommerceException {
		Userapp user = null;
		try {
			user = userAppRepository.findByUserName(userName);
			if (user == null) {
				throw new UsernameNotFoundException(KeyConstants.USER_NOT_FOUND);
			}
		} catch (Exception e) {
			throw e;
		}

		return user;
	}

	@Transactional
	public void registerUser(SignupRequest signupRequest) throws EcommerceException {
		try {
			if (userAppRepository.existsByUserName(signupRequest.getUsername())) {
				throw new EcommerceException(KeyConstants.ERROR_CODE_EXISTS_USER, KeyConstants.USER_EXISTS,
						KeyConstants.TECHNICAL_ERROR);
			}

			// Create new user's account
			Userapp user = new Userapp();
			user.setUserName(signupRequest.getUsername());
			user.setEmail(signupRequest.getEmail());
			user.setPassword(encoder.encode(signupRequest.getPassword()));
			user.setFirtsName(signupRequest.getFirstName());
			user.setSurname(signupRequest.getSurname());
			Profile profile = new Profile();
			profile.setProfileId(signupRequest.getIdProfile());
			user.setProfile(profile);

			userAppRepository.save(user);

		} catch (Exception e) {
			throw e;
		}

	}

}
