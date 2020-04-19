package com.logiq.heavyequipment.exceptions;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.logiq.heavyequipment.domain.response.ErrorResponse;
import com.logiq.heavyequipment.utils.ResponseUtils;

@RestControllerAdvice
@RequestMapping("/")
public class GlobalExceptionHandler {

	@ExceptionHandler(APIException.class)
	public ResponseEntity<ErrorResponse> handleAPIExceptions(APIException exception){

		HttpStatus status = HttpStatus.UNAUTHORIZED;
		
		if(exception.getErrorConstant().getStatusCode() == 400){
			status = HttpStatus.BAD_REQUEST;
		}else if(exception.getErrorConstant().getStatusCode() == 403){
			status = HttpStatus.FORBIDDEN;
		}else if(exception.getErrorConstant().getStatusCode() == 404){
			status = HttpStatus.NOT_FOUND;
		}
		
		
		return new ResponseEntity<ErrorResponse>(ResponseUtils.construct4xxErrorResponse(exception.getErrorConstant()), 
												 ResponseUtils.constructHeader(), 
										  		 status);
	}


	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException){

        return new ResponseEntity<ErrorResponse>(ResponseUtils.construct400ErrorResponse(methodArgumentTypeMismatchException.getMessage()),
        										 ResponseUtils.constructHeader(),
        										 HttpStatus.BAD_REQUEST);
    }
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> processValidationError(MethodArgumentNotValidException methodArgumentNotValidException){

        return new ResponseEntity<ErrorResponse>(ResponseUtils.construct400FieldErrorResponse(methodArgumentNotValidException.getBindingResult().getFieldErrors()),
        										 ResponseUtils.constructHeader(),
        										 HttpStatus.BAD_REQUEST);
    }

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponse> processValidationError(ConstraintViolationException constraintViolationException){

		return new ResponseEntity<ErrorResponse>(
				ResponseUtils.construct400ErrorResponse(
						constraintViolationException.getConstraintViolations().iterator().next().getMessage()),
				ResponseUtils.constructHeader(),
				HttpStatus.BAD_REQUEST);
	}
   
	@ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> handleExceptiond (NoHandlerFoundException ex) {
		
		return new ResponseEntity<ErrorResponse>(ResponseUtils.construct404ErrorResponse("No handler found for "+ex.getRequestURL()), 
				  						  		 ResponseUtils.constructHeader(), 
				  						  		 HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	public ResponseEntity<ErrorResponse> handleMediaTypeNotSupportedException (HttpMediaTypeNotSupportedException ex) {
		
		return new ResponseEntity<ErrorResponse>(ResponseUtils.construct415ErrorResponse(ex.getMessage()), 
				  								 ResponseUtils.constructHeader(), 
				  								 HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
	
    @ExceptionHandler(ProcessingException.class)
	public ResponseEntity<ErrorResponse> handleProcessingExceptipons(ProcessingException exception){

		return new ResponseEntity<ErrorResponse>(ResponseUtils.construct500ErrorResponse(exception.getErrorConstant()), 
												 ResponseUtils.constructHeader(), 
												 HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> handleNullPointerExceptipons(NullPointerException exception){
		exception.printStackTrace();
		
		return new ResponseEntity<ErrorResponse>(ResponseUtils.construct500ErrorResponse(), 
										  		 ResponseUtils.constructHeader(), 
										  		 HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> handleRuntimeExceptipons(RuntimeException exception){

		exception.printStackTrace();

		return new ResponseEntity<ErrorResponse>(ResponseUtils.construct500ErrorResponse(),
										  		 ResponseUtils.constructHeader(), 
										  		 HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException){
		
		return new ResponseEntity<ErrorResponse>(ResponseUtils.constructJWTTokenErrorResponse(illegalArgumentException.getMessage()),
												 ResponseUtils.constructHeader(),
												 HttpStatus.BAD_REQUEST);

	}

}
