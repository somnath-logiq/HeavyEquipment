package com.logiq.heavyequipment.enums;

import lombok.Getter;

@Getter
public enum ErrorConstants {

	EXISTING_USER("API-01", "This name already taken.", 400);

    private final String code;
    private final String description;
    private final int statusCode;
    
    private ErrorConstants(String code, String description, int statusCode) {
        this.code = code;
        this.description = description;
        this.statusCode = statusCode;
    }
    @Override
    public String toString() {
        return code + ": " + description;
    }



}
