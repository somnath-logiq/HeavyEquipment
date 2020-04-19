package com.logiq.heavyequipment.domain.response;

import java.util.ArrayList;
import java.util.List;

import com.logiq.heavyequipment.domain.APIError;

import lombok.Data;

@Data
public class ErrorResponse {

	private String code;
    private String message;
    private List<APIError> apiErrors = new ArrayList<>();

}
