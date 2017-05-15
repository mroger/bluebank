package br.com.bluebank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author Marcos (mroger.oliveira@gmail.com)
 *
 * Mapping exception to HTTP status
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No account found")
public class AccountNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String message) {
		super(message);
	}

}
