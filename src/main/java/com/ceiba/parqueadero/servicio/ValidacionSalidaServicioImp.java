package com.ceiba.parqueadero.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.util.RestIncorrecta;

@Service("validacionSalidaServicioImp")
public class ValidacionSalidaServicioImp implements ValidacionSalidaServicio {

	@Autowired
	VigilanteRepositorio vigilanteRepositorio;
	
	@Override
	public FichaTecnicaDeIngreso validarSalida(FichaTecnicaDeIngreso fichaTecnica) {
		//FichaTecnicaDeIngreso fichaTecnicaDeRetiro = vigilanteRepositorio.findbyPlacaYvehiculoActivo(fichaTecnica.getPlaca(),fichaTecnica.getTipoVehiculo());
		FichaTecnicaDeIngreso fichaTecnicaDeRetiro = vigilanteRepositorio.findbyPlacaYvehiculoActivo2(fichaTecnica.getPlaca());
		if(validacionCamposRequeridos(fichaTecnica)) {
			throw new RestIncorrecta(HttpStatus.BAD_REQUEST.value(),"El campo de la Placa no esta diligenciado");
		}
		
		if(fichaTecnicaDeRetiro == null) {
			throw new RestIncorrecta(HttpStatus.NOT_FOUND.value(),"Este vehiculo no ha ingresado");
		}
		
		return fichaTecnicaDeRetiro;

	}

	private boolean validacionCamposRequeridos(FichaTecnicaDeIngreso fichaTecnica) {
		return (fichaTecnica.getPlaca() == null || fichaTecnica.getPlaca().equals("") );
	}

}
