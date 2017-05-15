package br.com.bluebank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * Mapping exception to HTTP status
 */
@ResponseStatus(value=HttpStatus.CONFLICT, reason="Account has insufficient funds")
public class AccountNotEnoughFundsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountNotEnoughFundsException(String message) {
		super(message);
	}
	
}
