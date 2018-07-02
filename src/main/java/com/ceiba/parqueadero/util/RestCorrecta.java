package com.ceiba.parqueadero.util;


public class RestCorrecta{

	private int codigo;
	private String mensaje;
	
	public RestCorrecta(int codigo) {
		super();
		this.codigo = codigo;
	}

	public RestCorrecta(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


}