package com.logiq.heavyequipment.exceptions;

import com.logiq.heavyequipment.enums.ErrorConstants;

public class ProcessingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ErrorConstants errorConstant;

	public ProcessingException() {
		super();
	}

	public ProcessingException(String exceptionMessage) {
		super(exceptionMessage);
	}

	public ProcessingException(Throwable cause) {
		super(cause);
	}

	public ProcessingException(String exceptionMessage, Throwable cause) {
		super(exceptionMessage, cause);
	}

	public ProcessingException(ErrorConstants errorConstant) {
		super(errorConstant.toString());
		this.errorConstant = errorConstant;
	}

	public ErrorConstants getErrorConstant() {
		return errorConstant;
	}

	public void setErrorConstant(ErrorConstants errorConstant) {
		this.errorConstant = errorConstant;
	}

}
