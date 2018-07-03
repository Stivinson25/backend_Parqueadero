package com.ceiba.parqueadero.servicio;

import java.util.List;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.util.TipoVehiculo;

public interface FichaTecnicaDeIngresoServicio {

	void save(FichaTecnicaDeIngreso ftdi);
	
	FichaTecnicaDeIngreso findbyActivoYPlaca(String verificarPlaca);
	
	long countActivoYTipo(TipoVehiculo tipo);
	
	List<FichaTecnicaDeIngreso> findAll();

	void facturar(FichaTecnicaDeIngreso ftdi);

}
