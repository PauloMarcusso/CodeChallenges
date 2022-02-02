package com.api.amedigital.starwars.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Planeta não encontrada")
public class PlanetDomainException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlanetDomainException(String msg) {
		super(msg);
	}

	public PlanetDomainException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
