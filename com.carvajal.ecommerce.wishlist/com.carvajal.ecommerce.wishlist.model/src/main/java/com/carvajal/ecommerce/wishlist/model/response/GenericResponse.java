package com.carvajal.ecommerce.wishlist.model.response;

import java.io.Serializable;

public class GenericResponse implements Serializable {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7094182552257674595L;

}
