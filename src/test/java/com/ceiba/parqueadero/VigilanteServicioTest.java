package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.servicio.VigilanteServicio;
import com.ceiba.parqueadero.servicio.VigilanteServicioImp;
import com.ceiba.parqueadero.util.Estados;
import com.ceiba.parqueadero.util.TipoVehiculo;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=ParqueaderoApplication.class)
public class VigilanteServicioTest{
	
	@Autowired
	@Qualifier("vigilanteRepositorio")
	VigilanteRepositorio vigilanteRepositorio;
	
	@Test
	public void registrarVehiculoTest(){
		
		//arrange
		VigilanteServicio vigilanteServicio= new VigilanteServicioImp();		

		FichaTecnicaDeIngreso registroVehiculo = new FichaTecnicaDeIngreso("XXX456",TipoVehiculo.CARRO,new Date(),null,0, Estados.ACTIVO);		
		//Act
		vigilanteServicio.registrarVehiculo(registroVehiculo);
		//Assert
		assertEquals("XXX456", vigilanteRepositorio.findbyActivoYPlaca(registroVehiculo.getPlaca()));
	}
}
