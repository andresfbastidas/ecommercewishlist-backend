package com.carvajal.ecommerce.wishlist.model.commons;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FaultRoot implements Serializable{
	
	
	private Fault fault;

	@JsonProperty("fault")
	public Fault getFault() {
		return fault;
	}

	@JsonProperty("fault")
	public void setFault(Fault value) {
		this.fault = value;
	}
	
	private static final long serialVersionUID = -2091070586094694526L;
}