package gov.healthit.chpl.auth;


import gov.healthit.chpl.auth.json.ErrorJSONObject;
import gov.healthit.chpl.auth.jwt.JWTCreationException;
import gov.healthit.chpl.auth.permission.UserPermissionRetrievalException;
import gov.healthit.chpl.auth.user.UserCreationException;
import gov.healthit.chpl.auth.user.UserManagementException;
import gov.healthit.chpl.auth.user.UserRetrievalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice 
public class AuthExceptionControllerAdvice {
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorJSONObject> exception(AccessDeniedException e) {
		return new ResponseEntity<ErrorJSONObject>(new ErrorJSONObject("Access Denied"), HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(UserRetrievalException.class)
	public ResponseEntity<ErrorJSONObject> exception(UserRetrievalException e) {
		return new ResponseEntity<ErrorJSONObject>(new ErrorJSONObject(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserCreationException.class)
	public ResponseEntity<ErrorJSONObject> exception(UserCreationException e) {
		return new ResponseEntity<ErrorJSONObject>(new ErrorJSONObject(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserPermissionRetrievalException.class)
	public ResponseEntity<ErrorJSONObject>exception(UserPermissionRetrievalException e) {
		return new ResponseEntity<ErrorJSONObject>(new ErrorJSONObject(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserManagementException.class)
	public ResponseEntity<ErrorJSONObject> exception(UserManagementException e) {
		return new ResponseEntity<ErrorJSONObject>(new ErrorJSONObject(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(JWTCreationException.class)
	public ResponseEntity<ErrorJSONObject> exception(JWTCreationException e) {
		return new ResponseEntity<ErrorJSONObject>(new ErrorJSONObject(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
