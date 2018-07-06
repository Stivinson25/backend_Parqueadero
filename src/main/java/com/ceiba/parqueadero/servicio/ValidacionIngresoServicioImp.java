package com.ceiba.parqueadero.servicio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.util.Constante;
import com.ceiba.parqueadero.util.RestIncorrecta;
import com.ceiba.parqueadero.util.TipoVehiculo;

@Service("validacionIngresoServicioImp")
public class ValidacionIngresoServicioImp implements ValidacionIngresoServicio {

	@Autowired
	VigilanteRepositorio vigilanteRepositorio;
	
	@Override
	public void validar(FichaTecnicaDeIngreso fichaTecnica) {
		
		if(validacionCamposRequeridos(fichaTecnica.getPlaca())) {
			throw new RestIncorrecta(HttpStatus.BAD_REQUEST.value(),"El campo de la Placa no esta diligenciado");
		}
		if(!validarCuposDisponibles(fichaTecnica.getTipoVehiculo())) {
			throw new RestIncorrecta(HttpStatus.SERVICE_UNAVAILABLE.value(),"No hay cupos Disponibles en el parqueadero");
		}
		if(validacionExisteVehiculo(fichaTecnica) != 0) {
			throw new RestIncorrecta(HttpStatus.EXPECTATION_FAILED.value(),"Este vehiculo ya esta registrado");
		}
		if(validarTipoVehiculoYPlaca(fichaTecnica) && validarDiaDeLaSemana()){
			throw new RestIncorrecta(HttpStatus.NOT_ACCEPTABLE.value(),"Este dia el vehiculo no tiene autorizacion de ingreso");
		}
	}

	@Override
	public long validacionExisteVehiculo(FichaTecnicaDeIngreso fichaTecnica) {
		return vigilanteRepositorio.existbyActivoYPlaca(fichaTecnica.getPlaca());
	}

	@Override
	public boolean validarTipoVehiculoYPlaca(FichaTecnicaDeIngreso fichaTecnica) {
		return fichaTecnica.getTipoVehiculo()== TipoVehiculo.CARRO && fichaTecnica.getPlaca().charAt(0) == Constante.INICIO_DE_PLACA_NO_PERMITIDA;
	}

	@Override
	public boolean validarDiaDeLaSemana() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		int dia = cal.get(Calendar.DAY_OF_WEEK);
		return (dia == Constante.DOMINGO || dia == Constante.LUNES);
	}

	@Override
	public boolean validacionCamposRequeridos(String placa) {
		return (placa == null || placa.equals("") );
	}

	@Override
	public boolean validarCuposDisponibles(TipoVehiculo tipo) {
		if(tipo.equals(TipoVehiculo.CARRO)) {
			return vigilanteRepositorio.countActivoYTipo(tipo) < Constante.CUPOS_DISPONIBLES_CARRO;
		}else {
			return vigilanteRepositorio.countActivoYTipo(tipo) < Constante.CUPOS_DISPONIBLES_MOTO;
		}
		
	}

}
