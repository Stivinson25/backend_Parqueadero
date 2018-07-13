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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((placa == null) ? 0 : placa.hashCode());
		result = prime * result + ((tipoVehiculo == null) ? 0 : tipoVehiculo.hashCode());
		result = prime * result + (int) (valorApagar ^ (valorApagar >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Factura other = (Factura) obj;
		
		if (placa == null || other.placa != null)
				return false; 
		
		if (!placa.equals(other.placa))
			return false;
		else if (tipoVehiculo != other.tipoVehiculo)
			return false;
		else if (valorApagar != other.valorApagar)
			return (valorApagar != other.valorApagar);
		else return true;
	}
	
	

}
