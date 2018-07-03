package com.ceiba.parqueadero.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;

public class Validacion {
	public static final int DOMINGO=1;
	public static final int LUNES=2;
	
	public boolean validacionPlaca(FichaTecnicaDeIngreso ftdi,FichaTecnicaDeIngreso ftdiBD) {
			
			if(!valiadacionCampos(ftdi)) {
				return false;
			}else if(ftdiBD==null) {
				if(validarTipoYPlaca(ftdi)) {
					return diaDeLaSemana();
				}
				return true;
			}

			return false;
	}




	public boolean validarTipoYPlaca(FichaTecnicaDeIngreso ftdi) {
		return ftdi.getTipoVehiculo()== TipoVehiculo.CARRO && ftdi.getPlaca().charAt(0) == 'A';
	}




	public boolean diaDeLaSemana() {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		int dia = cal.get(Calendar.DAY_OF_WEEK);
		return !(dia == DOMINGO || dia == LUNES);
	}

	
	
	public boolean valiadacionCampos(FichaTecnicaDeIngreso ftdi) {
		boolean esValido=true;
		if(ftdi.getPlaca() == "" || ftdi.getPlaca() == null ) {
			esValido=false;
		}
		return esValido;
	}



}