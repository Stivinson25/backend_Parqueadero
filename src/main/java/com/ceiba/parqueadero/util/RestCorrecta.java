package com.ceiba.parqueadero.util;


public class RestCorrecta{

	private int codigo;
	private String mensaje;
	private long factura;
	
	public RestCorrecta(int codigo) {
		super();
		this.codigo = codigo;
	}

	public RestCorrecta(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public RestCorrecta(int codigo, String mensaje, long factura) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.factura = factura;
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

	public long getFactura() {
		return factura;
	}

	public void setFactura(long factura) {
		this.factura = factura;
	}


}