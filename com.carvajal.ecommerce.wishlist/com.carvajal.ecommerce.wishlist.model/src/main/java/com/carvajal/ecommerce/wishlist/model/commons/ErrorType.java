package com.carvajal.ecommerce.wishlist.model.commons;

import java.io.Serializable;

public class ErrorType implements Serializable{
	
	private String codeError;
	private String tecnicalMessage;
	private String userMessage;
	
	public ErrorType(String codeError, String tecnicalMessage, String userMessage) {
		super();
		this.codeError = codeError;
		this.tecnicalMessage = tecnicalMessage;
		this.userMessage = userMessage;	
	}
	
	public ErrorType() {
		
	}
	
	public String getCodeError() {
		return codeError;
	}

	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}

	public String getTecnicalMessage() {
		return tecnicalMessage;
	}

	public void setTecnicalMessage(String tecnicalMessage) {
		this.tecnicalMessage = tecnicalMessage;
	}

	public String getUserMessage() {
		return userMessage;
	}

	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	private static final long serialVersionUID = -6348066907171588578L;
}