package com.ceiba.parqueadero.servicio;

import java.util.List;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;

public interface FichaTecnicaDeIngresoServicio {

	void save(FichaTecnicaDeIngreso ftdi);
	
	FichaTecnicaDeIngreso findbyActivoYPlaca(String verificarPlaca);
	
	long countActivoYTipo(int tipo);
	
	List<FichaTecnicaDeIngreso> findAll();

	void facturar(FichaTecnicaDeIngreso ftdi);

}
