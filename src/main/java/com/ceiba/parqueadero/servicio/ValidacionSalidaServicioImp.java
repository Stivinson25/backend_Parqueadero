package com.ceiba.parqueadero.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.util.RestIncorrecta;

@Service("validacionSalidaServicioImp")
public class ValidacionSalidaServicioImp implements ValidacionSalidaServicio {

	@Autowired
	@Qualifier("vigilanteRepositorio")
	VigilanteRepositorio vigilanteRepositorio;
	
	@Override
	public FichaTecnicaDeIngreso validacionPlaca(FichaTecnicaDeIngreso fichaTecnica) {
		FichaTecnicaDeIngreso fichaTecnicaDeIngreso = new FichaTecnicaDeIngreso();
		fichaTecnicaDeIngreso= vigilanteRepositorio.findbyPlacaYvehiculoActivo(fichaTecnica.getPlaca());

		if(valiadacionCamposRequeridos(fichaTecnica)) {
			throw new RestIncorrecta(HttpStatus.BAD_REQUEST.value(),"El campo de la Placa no esta diligenciado");
		}
		
		if(fichaTecnicaDeIngreso == null) {
			throw new RestIncorrecta(HttpStatus.NOT_FOUND.value(),"Este vehiculo no ha ingresado");
		}
		
		return fichaTecnicaDeIngreso;

	}

	private boolean valiadacionCamposRequeridos(FichaTecnicaDeIngreso fichaTecnica) {
		return (fichaTecnica.getPlaca() == null || fichaTecnica.getPlaca().equals("") );
	}

}
