package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.servicio.ValidacionSalidaServicioImp;

@RunWith(SpringRunner.class) 
@SpringBootTest
public class ValidacionSalidaTest {

	@Mock
	VigilanteRepositorio vigilanteRepositorio;
	
	@Mock
	GregorianCalendar calendario;
	
	@Autowired
	@Qualifier("validacionSalidaServicioImp")
	ValidacionSalidaServicioImp validacion;
	
	@Before
	public void inicializacion() {
		MockitoAnnotations.initMocks(this);
	}
	

//	@Test
//	public void validarCampoPlacaIngresadaVacia(){	
//		//arrange	
//		FichaTecnicaDeIngreso ftdi = new FichaTecnicaDeIngreso(0,"ABC123",null,null,null,0,null);
//		//act	
//	    try {
//	    	validacion.validacionPlaca(ftdi);
//		} catch (Exception e) {
//			//Assert
//			assertEquals("El campo de la Placa no esta diligenciado",e.getMessage());
//		}
//	}
}
