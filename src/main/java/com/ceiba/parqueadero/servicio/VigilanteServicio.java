package com.ceiba.parqueadero.servicio;

import java.util.List;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.util.TipoVehiculo;

public interface VigilanteServicio {

	void registrarVehiculo(FichaTecnicaDeIngreso ftdi);
	
	long findbyActivoYPlaca(String verificarPlaca);
	
	long countActivoYTipo(TipoVehiculo tipo);
	
	List<FichaTecnicaDeIngreso> findAllEstadoActivo();

	long facturar(FichaTecnicaDeIngreso ftdi);

}
