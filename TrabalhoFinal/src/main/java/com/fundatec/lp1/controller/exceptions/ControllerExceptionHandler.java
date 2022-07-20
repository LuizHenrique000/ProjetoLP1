package com.fundatec.lp1.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fundatec.lp1.service.exceptions.EntityNotFoundException;
import com.fundatec.lp1.service.exceptions.IsTitularException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Recurso n√£o encontrado");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler()
	public ResponseEntity<StandardError> isTitularException(IsTitularException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
		err.setError("O cliente n„o pode ser deletado pois È titular de uma conta");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}

}
