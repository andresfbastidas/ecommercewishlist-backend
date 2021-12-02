package com.carvajal.ecommerce.wishlist.business.utils;

import org.springframework.stereotype.Component;

import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;
import com.carvajal.ecommerce.wishlist.model.utils.ComponentUtils;

@Component
public class ServiceUtils extends ComponentUtils {

	protected static final String BUSINESSCODE = "BE001";

	protected static final String BUSINESS_TYPE = "BUSINESS";

	protected static final String LOGGER_ERROR = "ERROR";

	

	public void buildCustomException(String msgKey, String businessCode)
			throws EcommerceException {
		callCustomException(msgKey, null, businessCode);
	}

	public void callCustomException(String msgKey, Exception e)
			throws EcommerceException {
		throw new EcommerceException(BUSINESSCODE, getErrMessage(msgKey), BUSINESS_TYPE,
				LOGGER_ERROR, e);
	}

	public void callCustomException(String msgKey, Exception e, String businessCode)
			throws EcommerceException {
		throw new EcommerceException(businessCode,
				getErrMessage(msgKey), BUSINESS_TYPE, LOGGER_ERROR, e);
	}
	
	public void callCustomException(String msgKey, Exception e, String businessCode, String msjConcatenado)
			throws EcommerceException {
		throw new EcommerceException(businessCode,
				getErrMessage(msgKey) + " " + msjConcatenado, BUSINESS_TYPE, LOGGER_ERROR, e);
	}

}
