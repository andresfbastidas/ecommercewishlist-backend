package com.carvajal.ecommerce.wishlist.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.ecommerce.wishlist.business.implement.UserDetailsServiceImpl;
import com.carvajal.ecommerce.wishlist.controller.constant.FcdConstants;
import com.carvajal.ecommerce.wishlist.controller.security.JwtUtils;
import com.carvajal.ecommerce.wishlist.model.constant.KeyConstants;
import com.carvajal.ecommerce.wishlist.model.dao.UserDetailsDAO;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.model.request.LoginRequest;
import com.carvajal.ecommerce.wishlist.model.request.SignupRequest;
import com.carvajal.ecommerce.wishlist.model.response.GenericResponse;
import com.carvajal.ecommerce.wishlist.model.response.JwtResponse;


@RestController
@RequestMapping(path = FcdConstants.USER)
public class UserSecurityController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	UserDetailsServiceImpl userServiceImpl;

	@PostMapping(FcdConstants.LOGIN)
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsDAO userDetails = (UserDetailsDAO) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@PostMapping(FcdConstants.CREATE_USER)
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest)
			throws EcommerceException {

		userServiceImpl.registerUser(signUpRequest);
		GenericResponse genericResponse = new GenericResponse();
		genericResponse.setMessage(KeyConstants.SUCCESS_CREATE_USER);
		return new ResponseEntity<>(genericResponse, HttpStatus.OK);
	}

}
