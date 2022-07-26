package com.fundatec.lp1.service.exceptions;

public class SenhaInvalidaException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public SenhaInvalidaException(String msg) {
		super(msg);
	}
	
}
