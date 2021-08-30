package com.hulk.store.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;

import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hulk.store.exception.api.ErrorResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class ApiExceptionHandler.
 */
@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	/**
	 * Handle method argument not valid.
	 *
	 * @param ex the ex
	 * @param headers the headers
	 * @param status the status
	 * @param request the request
	 * @return the response entity
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}
		for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
			errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
		}
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
		return handleExceptionInternal(ex, errorResponse, headers, errorResponse.getStatus(), request);
	}

	/**
	 * Gets the builds the.
	 *
	 * @param errors the errors
	 * @param localizedMessage the localized message
	 * @param httpStatus the http status
	 * @return the builds the
	 */
	private ErrorResponse getBuild(List<String> errors, String localizedMessage, HttpStatus httpStatus) {
		return ErrorResponse.builder().status(httpStatus).message(localizedMessage).errors(errors).build();
	}

	/**
	 * Handle spring boot validation.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ javax.validation.ConstraintViolationException.class })
	public ResponseEntity<ErrorResponse> handleSpringBootValidation(javax.validation.ConstraintViolationException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errors.add(violation.getMessage());
		}
		ErrorResponse errorResponse = getBuild(errors, "Error en validación de parámetros", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle constraint violation.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<ErrorResponse> handleConstraintViolation(ConstraintViolationException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getConstraintName());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle reservation not found exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleReservationNotFoundException(Exception ex, WebRequest request) {
		ErrorResponse errorResponse = ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR)
				.message("internal server error").build();
		return handleExceptionInternal(ex, errorResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	/**
	 * Handle data exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ DataException.class })
	public ResponseEntity<ErrorResponse> handleDataException(DataException ex, WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle product not found exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ ProductNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleProductNotFoundException(ProductNotFoundException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle product exist exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ ProductExistException.class })
	public ResponseEntity<ErrorResponse> handleProductExistException(ProductExistException ex, WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle product category not found exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ ProductCategoryNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleProductCategoryNotFoundException(ProductCategoryNotFoundException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle product category exist exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ ProductCategoryExistException.class })
	public ResponseEntity<ErrorResponse> handleProductCategoryExistException(ProductCategoryExistException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle inventory not found exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ InventoryNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleInventoryNotFoundException(InventoryNotFoundException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle user exist exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ UserExistException.class })
	public ResponseEntity<ErrorResponse> handleUserExistException(UserExistException ex, WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle user not found exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ UserNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle brand card exist exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ BrandCardExistException.class })
	public ResponseEntity<ErrorResponse> handleBrandCardExistException(BrandCardExistException ex, WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle credit card exist exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ CreditCardExistException.class })
	public ResponseEntity<ErrorResponse> handleCreditCardExistException(CreditCardExistException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle no stock exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ NoStockException.class })
	public ResponseEntity<ErrorResponse> handleNoStockException(NoStockException ex, WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle shopping cart not found exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ ShoppingCartNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleShoppingCartNotFoundException(ShoppingCartNotFoundException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

	/**
	 * Handle credit card not found exception.
	 *
	 * @param ex the ex
	 * @param request the request
	 * @return the response entity
	 */
	@ExceptionHandler({ CreditCardNotFoundException.class })
	public ResponseEntity<ErrorResponse> handleCreditCardNotFoundException(CreditCardNotFoundException ex,
			WebRequest request) {
		List<String> errors = new ArrayList<>();
		errors.add(ex.getCause().getMessage());
		ErrorResponse errorResponse = getBuild(errors, ex.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(errorResponse, new HttpHeaders(), errorResponse.getStatus());
	}

}
