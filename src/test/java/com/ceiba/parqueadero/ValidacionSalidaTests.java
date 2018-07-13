package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

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
import com.ceiba.parqueadero.servicio.ValidacionSalidaServicioImp;
import com.ceiba.parqueadero.util.TipoVehiculo;

@RunWith(SpringRunner.class) 
@SpringBootTest
public class ValidacionSalidaTests {
	@Mock
	VigilanteRepositorio vigilanteRepositorio;
	
	@Mock
	GregorianCalendar calendario;
	
	@Autowired
	ValidacionSalidaServicioImp validacion;
	
	@Before
	public void inicializacion() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void validarCampoPlacaIngresadaVacia(){	
		//arrange	
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso(0,"",TipoVehiculo.MOTO,null,null,0,null);
		Mockito.when(vigilanteRepositorio.countActivoYTipo(fichaTecnica.getTipoVehiculo())).thenReturn((long) 1);
		//act	
	    try {
	    	validacion.validarSalida(fichaTecnica);
		} catch (Exception e) {
			//Assert
			assertEquals("El campo de la Placa no esta diligenciado",e.getMessage());
		}
	}
	
	@Test
	public void validarExisteCarro(){	
		//arrange	
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso(0,"PLACA",TipoVehiculo.CARRO,null,null,0,null);		
		Mockito.when(vigilanteRepositorio.findbyPlacaYvehiculoActivo2(fichaTecnica.getPlaca())).thenReturn(null);
		//act	
	    try {
	    	validacion.validarSalida(fichaTecnica);
		} catch (Exception e) {
			//Assert
			assertEquals("Este vehiculo no ha ingresado",e.getMessage());
		}
	}
}
