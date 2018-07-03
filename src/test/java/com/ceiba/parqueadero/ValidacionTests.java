package com.ceiba.parqueadero;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.util.Validacion;

public class ValidacionTests {
	
	@Test
	public void validarCampoPlaca(){	
		//arrange
		Validacion validacion = new Validacion();
		FichaTecnicaDeIngreso ftdi = new FichaTecnicaDeIngreso(0,"PLACA",null,null,0,null);
		//act	
		boolean resultado=validacion.valiadacionCampos(ftdi);
		//assert	
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void validarCampoPlacaVacia(){	
		//arrange
		Validacion validacion = new Validacion();
		FichaTecnicaDeIngreso ftdi = new FichaTecnicaDeIngreso(0,"",null,null,0,null);
		//act	
		boolean resultado=validacion.valiadacionCampos(ftdi);
		//assert	
		Assert.assertFalse(resultado);
	}

	@Test
	public void validarDiaNoPermitido(){	
		//arrange
		FichaTecnicaDeIngreso ftdi = new FichaTecnicaDeIngreso();
	  	Validacion validacionDia = Mockito.spy(Validacion.class);
	
	  	Mockito.when(validacionDia.valiadacionCampos(ftdi)).thenReturn(true);
	  	Mockito.when(validacionDia.validarTipoYPlaca(ftdi)).thenReturn(true);
	    Mockito.when(validacionDia.diaDeLaSemana()).thenReturn(false);
	   	//Act
	   	boolean resultado = validacionDia.validacionPlaca(ftdi, null);
	   	//Assert
	   	assertFalse(resultado);
	}
	
	@Test
	public void validarDiaPermitido(){	
		//arrange
		FichaTecnicaDeIngreso ftdi = new FichaTecnicaDeIngreso();
	  	Validacion validacionDia = Mockito.spy(Validacion.class);
	
	  	Mockito.when(validacionDia.valiadacionCampos(ftdi)).thenReturn(true);
	  	Mockito.when(validacionDia.validarTipoYPlaca(ftdi)).thenReturn(true);
	    Mockito.when(validacionDia.diaDeLaSemana()).thenReturn(true);
	   	//Act
	   	boolean resultado = validacionDia.validacionPlaca(ftdi, null);
	   	//Assert
	   	assertTrue(resultado);
	}
	
	@Test
	public void validarPlacaNoPermitida(){	
		//arrange
		FichaTecnicaDeIngreso ftdi = new FichaTecnicaDeIngreso();
	  	Validacion validacionDia = Mockito.spy(Validacion.class);
	
	  	Mockito.when(validacionDia.valiadacionCampos(ftdi)).thenReturn(true);
	  	Mockito.when(validacionDia.validarTipoYPlaca(ftdi)).thenReturn(false);
	    Mockito.when(validacionDia.diaDeLaSemana()).thenReturn(true);
	   	//Act
	   	boolean resultado = validacionDia.validacionPlaca(ftdi, null);
	   	//Assert
	   	assertTrue(resultado);
	}
	
	@Test
	public void validarPlacaPermitida(){	
		//arrange
		FichaTecnicaDeIngreso ftdi = new FichaTecnicaDeIngreso();
	  	Validacion validacionDia = Mockito.spy(Validacion.class);
	
	  	Mockito.when(validacionDia.valiadacionCampos(ftdi)).thenReturn(true);
	  	Mockito.when(validacionDia.validarTipoYPlaca(ftdi)).thenReturn(true);
	    Mockito.when(validacionDia.diaDeLaSemana()).thenReturn(true);
	   	//Act
	   	boolean resultado = validacionDia.validacionPlaca(ftdi, null);
	   	//Assert
	   	assertTrue(resultado);
	}
}
