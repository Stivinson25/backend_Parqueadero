package com.ceiba.parqueadero.modelo;

import com.ceiba.parqueadero.util.TipoVehiculo;

public class Factura {
	
	private String placa;
	private TipoVehiculo tipoVehiculo;
	private long valorApagar;
	
	public Factura(String placa, TipoVehiculo tipoVehiculo, long valorApagar) {
		super();
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.valorApagar = valorApagar;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public TipoVehiculo getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public long getValorApagar() {
		return valorApagar;
	}

	public void setValorApagar(long valorApagar) {
		this.valorApagar = valorApagar;
	}
	
	@Override
	public boolean equals(Object obj) {

		Factura facturaAcomparar = (Factura) obj;
		
		return this.valorApagar == facturaAcomparar.valorApagar && tipoVehiculo.equals(facturaAcomparar.tipoVehiculo);
	}
	
	

}
