package com.ceiba.parqueadero;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.util.Estados;
import com.ceiba.parqueadero.util.Validacion;

public class ValidacionPlacaTests {
	
	@Test
	public void validarPlacaCarroA(){	
		//arrange
		FichaTecnicaDeIngreso ftdi = new FichaTecnicaDeIngreso(0,"AHG 56B",0,new Date(), 0,Estados.ACTIVO);
		//act	
		boolean resultado=Validacion.validacionPlaca(ftdi);
		//assert	
		Assert.assertTrue(resultado);
	}
}
