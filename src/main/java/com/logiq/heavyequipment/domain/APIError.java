package com.logiq.heavyequipment.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class APIError implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String field;
    private String message;
    private String violatedConstraint;

}
