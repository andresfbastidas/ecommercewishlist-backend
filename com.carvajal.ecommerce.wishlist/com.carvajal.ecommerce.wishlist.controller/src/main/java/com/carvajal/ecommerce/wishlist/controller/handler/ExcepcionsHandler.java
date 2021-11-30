package com.carvajal.ecommerce.wishlist.controller.handler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.carvajal.ecommerce.wishlist.model.commons.ErrorType;
import com.carvajal.ecommerce.wishlist.model.commons.Fault;
import com.carvajal.ecommerce.wishlist.model.commons.FaultRoot;
import com.carvajal.ecommerce.wishlist.model.exception.EcommerceException;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestControllerAdvice
public class ExcepcionsHandler {

	private static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ";
	private static final Logger LOGGER = LoggerFactory.getLogger(ExcepcionsHandler.class);

	@ExceptionHandler()
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	//@formatter:off
	@ApiResponse(responseCode = "500", 
				 description = "Internal Server Error", 
				 content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, 
				 schema = @Schema(implementation = FaultRoot.class)))
	//@formatter:on
	public ResponseEntity<Object> handleControlApplicationException(EcommerceException cae) {

		ErrorType error = new ErrorType();
		error.setCodeError(cae.getCode());
		error.setTecnicalMessage(cae.getType());
		error.setUserMessage(cae.getMessage());
		List<ErrorType> errors = new ArrayList<>();
		errors.add(error);

		return new ResponseEntity<>(mapError(errors), HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler()
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	//@formatter:off
	@ApiResponse(responseCode = "500", 
				 description = "Internal Server Error", 
				 content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, 
				 schema = @Schema(implementation = FaultRoot.class)))
	//@formatter:on
	public ResponseEntity<Object> handleException(Exception e) {

		LOGGER.error("Reference Point { Unhandle} - Error Message {" + e.getMessage() + "}", e);

		ErrorType error = new ErrorType();
		error.setCodeError("100");
		error.setTecnicalMessage(e.getMessage());
		error.setUserMessage(e.getMessage());
		List<ErrorType> errors = new ArrayList<>();
		errors.add(error);

		return new ResponseEntity<>(mapError(errors), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	//@formatter:off
	@ApiResponse(responseCode = "500", 
				 description = "Internal Server Error", 
				 content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, 
				 schema = @Schema(implementation = FaultRoot.class)))
	//@formatter:on
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {

		ErrorType err = new ErrorType();
		err.setCodeError("099");
		err.setTecnicalMessage("FATAL");
		err.setUserMessage("No es posible porcesar la transaccion en este momento, por favor reintente mas tarde");

		List<ErrorType> errors = new ArrayList<>();
		errors.add(err);
		ex.getBindingResult().getAllErrors().forEach(error -> err.setTecnicalMessage(error.getDefaultMessage()));

		return new ResponseEntity<>(mapError(errors), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private FaultRoot mapError(List<ErrorType> errors) {

		Fault fault = new Fault();
		fault.setErrors(errors);
		fault.setDateTx(formatDate());

		FaultRoot faultRoot = new FaultRoot();
		faultRoot.setFault(fault);
		return faultRoot;
	}

	private static String formatDate() {
		return DateFormatUtils.format(Calendar.getInstance().getTime(), DATE_FORMAT);
	}
}
