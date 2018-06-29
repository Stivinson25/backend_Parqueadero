package com.ceiba.parqueadero.util;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;

public class Validacion {
	
	public static boolean validacionPlaca(FichaTecnicaDeIngreso ftdi) {
			
			if(!valiadacionCampos(ftdi)) {
				return false;
			}else if(ftdi.getPlaca().charAt(0) == 'A') {
				return true;
			}
			return false;
	}

	
	
	public static boolean valiadacionCampos(FichaTecnicaDeIngreso ftdi) {

	boolean esValido=true;
		if(ftdi.getPlaca() == "") {
			esValido=false;
		}
		return esValido;
	}



}
