package com.logiq.heavyequipment.exceptions;

import com.logiq.heavyequipment.enums.ErrorConstants;


public class APIException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ErrorConstants errorConstant;
	
	public APIException(ErrorConstants errorConstant) {
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
