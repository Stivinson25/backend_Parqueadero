package com.ceiba.parqueadero.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_ACCEPTABLE) //value=HttpStatus.NOT_ACCEPTABLE
public class RestIncorrecta extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public RestIncorrecta(String mensaje) {
		super(mensaje);
	}

}
