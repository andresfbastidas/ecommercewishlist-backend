package com.carvajal.ecommerce.wishlist.model.exception;

import java.io.Serializable;

public class EcommerceException extends Exception implements Serializable {

	private String code;
	private String message;
	private String type;
	private String loggerReference;

	public EcommerceException(String code, String message, String type, String loggerReference,
			Throwable cause) {
		super(message,cause);
		this.code = code;
		this.message = message;
		this.type = type;
		this.loggerReference = loggerReference;
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

	public String getLoggerReference() {
		return loggerReference;
	}

	public void setLoggerReference(String loggerReference) {
		this.loggerReference = loggerReference;
	}

	private static final long serialVersionUID = -3190981567763867372L;

}
