package com.logiq.heavyequipment.utils;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.logiq.heavyequipment.constants.StatusConstants;
import com.logiq.heavyequipment.domain.APIError;
import com.logiq.heavyequipment.domain.response.ErrorResponse;
import com.logiq.heavyequipment.enums.ErrorConstants;

public class ResponseUtils {

	public static ResponseEntity<Object> constructResponseEntity(Object object, HttpStatus status) {
		return new ResponseEntity<Object>(object, constructHeader(), status);
	}

	public static HttpHeaders constructHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setPragma(StatusConstants.NOCACHE);
		headers.setCacheControl(StatusConstants.CACHECONTROL);
		headers.setExpires(StatusConstants.EXPIRES);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	public static ErrorResponse construct400ErrorResponse(String errorMessage) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setCode("API_400");
		errorResponse.setMessage("The API rejected request as: " + errorMessage);
		errorResponse.getApiErrors();

		return errorResponse;
	}

	public static ErrorResponse construct400FieldErrorResponse(List<FieldError> allErrors) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode("API_400");
		errorResponse.setMessage("The API rejected request due to errors below.");

		for (FieldError fieldError : allErrors) {
			APIError error = new APIError();
			error.setField(fieldError.getField());
			error.setViolatedConstraint(fieldError.getCode());
			error.setMessage(fieldError.getDefaultMessage());
			errorResponse.getApiErrors().add(error);
		}

		return errorResponse;
	}

	public static ErrorResponse construct400ErrorResponse(List<ObjectError> allErrors, Object rejectedValue) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setCode("API_400");
		errorResponse.setMessage("The API rejected request due to errors below.");

		for (ObjectError objectError : allErrors) {
			APIError error = new APIError();
			error.setField(objectError.getObjectName());
			error.setViolatedConstraint(objectError.getCode());
			error.setMessage(objectError.getDefaultMessage());
			errorResponse.getApiErrors().add(error);
		}

		return errorResponse;
	}

	public static ErrorResponse construct4xxErrorResponse(ErrorConstants errorConstant) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(errorConstant.getCode());
		errorResponse.setMessage(errorConstant.getDescription());
		errorResponse.getApiErrors();

		return errorResponse;
	}

	public static ErrorResponse construct404ErrorResponse(String errorMessage) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode("API_404");
		errorResponse.setMessage(errorMessage);
		errorResponse.getApiErrors();

		return errorResponse;
	}

	public static ErrorResponse construct415ErrorResponse(String errorMessage) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setCode("API_415");
		errorResponse.setMessage(errorMessage);

		errorResponse.getApiErrors();

		return errorResponse;
	}

	public static ErrorResponse construct500ErrorResponse(ErrorConstants errorConstant) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(errorConstant.getCode());
		errorResponse.setMessage(errorConstant.getDescription());
		errorResponse.getApiErrors();
		return errorResponse;
	}

	public static ErrorResponse construct500ErrorResponse() {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode("API_500");
		errorResponse.setMessage("Sorry, we could not process your request. Please try again later.");
		errorResponse.getApiErrors();

		return errorResponse;
	}

	public static ErrorResponse construct500ErrorResponse(String errorMessage) {

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode("API_500");
		errorResponse.setMessage(errorMessage);
		errorResponse.getApiErrors();

		return errorResponse;
	}

	public static ErrorResponse constructJWTTokenErrorResponse(String errorMessage) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode("API_401");
		errorResponse.setMessage(errorMessage);
		errorResponse.getApiErrors();

		return errorResponse;
	}

}
