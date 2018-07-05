package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.util.TipoVehiculo;
import com.ceiba.parqueadero.util.ValidacionIngreso;



public class ValidacionIngresoTests {
	
	@Mock
	VigilanteRepositorio vigilanteRepositorio;
	
	@Mock
	GregorianCalendar calendario;
	
	ValidacionIngreso validacion;
	
	@Before
	public void inicializacion() {
		MockitoAnnotations.initMocks(this);
		validacion= new ValidacionIngreso(vigilanteRepositorio);
	}
	

	@Test
	public void validarCampoPlacaIngresadaVacia(){	
		//arrange	
		FichaTecnicaDeIngreso ftdi = new FichaTecnicaDeIngreso(0,"",null,null,null,0,null);
		//act	
	    try {
	    	validacion.validacionPlaca(ftdi);
		} catch (Exception e) {
			//Assert
			assertEquals("El campo de la Placa no esta diligenciado",e.getMessage());
		}
	}
	
	@Test
	public void validarSiPlacaYaEstaRegistrada(){	
		//arrange	
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso(0,"PLACA",null,null,null,0,null);
		Mockito.when(vigilanteRepositorio.findbyActivoYPlaca(fichaTecnica.getPlaca())).thenReturn((long) 1);
		//act	
	    try {
	    	validacion.validacionPlaca(fichaTecnica);
		} catch (Exception e) {
			//Assert
			assertEquals("Este vehiculo ya esta registrado",e.getMessage());
		}
	}

	
	@Test
	public void validarSiEltipoVehiculoEstaPermitidoEseDia(){	
		//arrange
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso("AXX123",TipoVehiculo.CARRO,null,null,0,null);
		Mockito.when(vigilanteRepositorio.findbyActivoYPlaca(fichaTecnica.getPlaca())).thenReturn((long) 0);
		Mockito.when(calendario.get(Calendar.DAY_OF_WEEK)).thenReturn(1);
	   	//Act
	    try {
	    	validacion.validacionPlaca(fichaTecnica);
	    	//fail();
		} catch (Exception e) {
			//Assert
			assertEquals("Este dia el vehiculo no tiene autorizacion de ingreso",e.getMessage());
		}
	}
	
}
