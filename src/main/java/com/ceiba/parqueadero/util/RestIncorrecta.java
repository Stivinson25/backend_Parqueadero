package com.ceiba.parqueadero.util;


import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class RestIncorrecta extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private final int codigo;
	
	public RestIncorrecta(int codigo, String mensaje) {
		super(mensaje);
		this.codigo=codigo;
	}

	public int getCodigo() {
		return codigo;
	}

}
