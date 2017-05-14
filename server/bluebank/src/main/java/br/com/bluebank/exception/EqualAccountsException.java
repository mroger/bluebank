package br.com.bluebank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT, reason="Origin and destination accounts cannot be the same")
public class EqualAccountsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EqualAccountsException(String message) {
		super(message);
	}
	
	

}
