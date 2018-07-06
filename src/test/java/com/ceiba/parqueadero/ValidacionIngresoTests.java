package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.servicio.ValidacionIngresoServicioImp;
import com.ceiba.parqueadero.util.TipoVehiculo;

@RunWith(SpringRunner.class) 
@SpringBootTest
public class ValidacionIngresoTests {
	
	@Mock
	VigilanteRepositorio vigilanteRepositorio;
	
	@Mock
	GregorianCalendar calendario;
	
	@Autowired
	ValidacionIngresoServicioImp validacion;
	
	@Before
	public void inicializacion() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void validarCuposDisponiblesCarro(){	
		//arrange	
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso(0,"PLACA",TipoVehiculo.CARRO,null,null,0,null);
		Mockito.when(vigilanteRepositorio.countActivoYTipo(fichaTecnica.getTipoVehiculo())).thenReturn((long) 20);
		//act	
	    try {
	    	validacion.validar(fichaTecnica);
		} catch (Exception e) {
			//Assert
			assertEquals("No hay cupos Disponibles en el parqueadero",e.getMessage());
		}
	}

	@Test
	public void validarCuposDisponiblesMoto(){	
		//arrange	
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso(0,"PLACA",TipoVehiculo.MOTO,null,null,0,null);
		Mockito.when(vigilanteRepositorio.countActivoYTipo(fichaTecnica.getTipoVehiculo())).thenReturn((long) 10);
		//act	
	    try {
	    	validacion.validar(fichaTecnica);
		} catch (Exception e) {
			//Assert
			assertEquals("No hay cupos Disponibles en el parqueadero",e.getMessage());
		}
	}
	@Test
	public void validarCampoPlacaIngresadaVacia(){	
		//arrange	
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso(0,"",TipoVehiculo.MOTO,null,null,0,null);
		Mockito.when(vigilanteRepositorio.countActivoYTipo(fichaTecnica.getTipoVehiculo())).thenReturn((long) 1);
		//act	
	    try {
	    	validacion.validar(fichaTecnica);
		} catch (Exception e) {
			//Assert
			assertEquals("El campo de la Placa no esta diligenciado",e.getMessage());
		}
	}
	
	@Test
	public void validarSiPlacaYaEstaRegistrada(){	
		//arrange	
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso(0,"PLACA",TipoVehiculo.MOTO,null,null,0,null);
		Mockito.when(vigilanteRepositorio.countActivoYTipo(fichaTecnica.getTipoVehiculo())).thenReturn((long) 1);
		Mockito.when(vigilanteRepositorio.existbyActivoYPlaca(fichaTecnica.getPlaca())).thenReturn((long) 1);
		//act	
	    try {
	    	validacion.validar(fichaTecnica);
		} catch (Exception e) {
			//Assert
			assertEquals("Este vehiculo ya esta registrado",e.getMessage());
		}
	}

	
	@Test
	public void validarSiEltipoVehiculoEstaPermitidoEseDia(){	
		//arrange
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso("AXX123",TipoVehiculo.CARRO,null,null,0,null);
		Mockito.when(vigilanteRepositorio.countActivoYTipo(fichaTecnica.getTipoVehiculo())).thenReturn((long) 1);
		Mockito.when(vigilanteRepositorio.existbyActivoYPlaca(fichaTecnica.getPlaca())).thenReturn((long) 0);
		Mockito.when(calendario.get(Calendar.DAY_OF_WEEK)).thenReturn(1);
	   	//Act
	    try {
	    	validacion.validar(fichaTecnica);
	    	//fail();
		} catch (Exception e) {
			//Assert
			assertEquals("Este dia el vehiculo no tiene autorizacion de ingreso",e.getMessage());
		}
	}
	
}
