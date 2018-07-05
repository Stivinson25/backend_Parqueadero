package com.ceiba.parqueadero.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;


@Service
public class ValidacionIngreso{
	
	private static final char INICIO_DE_PLACA_NO_PERMITIDA = 'A';
	private static final int DOMINGO=1;
	private static final int LUNES=2;
	
	@Qualifier("vigilanteRepositorio")
	private VigilanteRepositorio vigilanteRepositorio;
	
	public ValidacionIngreso(VigilanteRepositorio vigilanteRepositorio) {
		this.vigilanteRepositorio = vigilanteRepositorio;
	}


		
	public void validacionPlaca(FichaTecnicaDeIngreso fichaTecnica) {
			
			if(valiadacionCamposRequeridos(fichaTecnica)) {
				throw new RestIncorrecta(HttpStatus.BAD_REQUEST.value(),"El campo de la Placa no esta diligenciado");
			}
			if(validacionExisteVehiculo(fichaTecnica) != 0) {
				throw new RestIncorrecta(HttpStatus.EXPECTATION_FAILED.value(),"Este vehiculo ya esta registrado");
			}
			if(validarTipoVehiculoYPlaca(fichaTecnica) && validarDiaDeLaSemana()){
				throw new RestIncorrecta(HttpStatus.NOT_ACCEPTABLE.value(),"Este dia el vehiculo no tiene autorizacion de ingreso");
			}
	}


	public long validacionExisteVehiculo(FichaTecnicaDeIngreso fichaTecnica) {
		return vigilanteRepositorio.findbyActivoYPlaca(fichaTecnica.getPlaca());
	}

	public boolean validarTipoVehiculoYPlaca(FichaTecnicaDeIngreso fichaTecnica) {
		return fichaTecnica.getTipoVehiculo()== TipoVehiculo.CARRO && fichaTecnica.getPlaca().charAt(0) == INICIO_DE_PLACA_NO_PERMITIDA;
	}

	public boolean validarDiaDeLaSemana() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		int dia = cal.get(Calendar.DAY_OF_WEEK);
		return (dia == DOMINGO || dia == LUNES); 
	}

	public boolean valiadacionCamposRequeridos(FichaTecnicaDeIngreso fichaTecnica) {
		return (fichaTecnica.getPlaca() == null || fichaTecnica.getPlaca().equals("") );
	}



}
