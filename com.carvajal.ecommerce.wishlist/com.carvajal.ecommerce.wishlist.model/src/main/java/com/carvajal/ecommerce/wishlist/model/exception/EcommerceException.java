package com.carvajal.ecommerce.wishlist.model.exception;

import java.io.Serializable;

public class EcommerceException extends Exception implements Serializable {

	private String code;
	private String message;
	private String type;

	public EcommerceException(String code, String message, String type) {
		super();
		this.code = code;
		this.message = message;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private static final long serialVersionUID = -8067072434392824924L;
}
