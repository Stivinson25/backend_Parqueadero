package com.ceiba.parqueadero.servicio;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.util.TipoVehiculo;

public interface ValidacionIngresoServicio {
	
	boolean validarCuposDisponibles(TipoVehiculo tipoVehiculo);
	
	void validar(FichaTecnicaDeIngreso fichaTecnica);
	
	long validacionExisteVehiculo(FichaTecnicaDeIngreso fichaTecnica);
	
	boolean validarTipoVehiculoYPlaca(FichaTecnicaDeIngreso fichaTecnica);
	
	boolean validarDiaDeLaSemana();
	
	boolean validacionCamposRequeridos(String placa);

}
