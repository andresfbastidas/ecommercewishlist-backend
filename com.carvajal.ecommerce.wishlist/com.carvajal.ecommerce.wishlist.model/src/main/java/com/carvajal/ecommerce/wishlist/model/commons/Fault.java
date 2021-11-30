package com.carvajal.ecommerce.wishlist.model.commons;

import java.io.Serializable;
import java.util.List;

public class Fault implements Serializable {

	private List<ErrorType> errors;
	private String dateTx;

	public Fault() {

	}

	public Fault(List<ErrorType> errors) {
		super();
		this.errors = errors;
	}

	public List<ErrorType> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorType> errors) {
		this.errors = errors;
	}

	public String getDateTx() {
		return dateTx;
	}

	public void setDateTx(String dateTx) {
		this.dateTx = dateTx;
	}

	private static final long serialVersionUID = -3134295202424607364L;
}