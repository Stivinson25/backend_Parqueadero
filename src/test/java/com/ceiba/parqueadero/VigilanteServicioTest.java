package com.ceiba.parqueadero;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.servicio.VigilanteServicioImp;
import com.ceiba.parqueadero.util.Estados;
import com.ceiba.parqueadero.util.TipoVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ParqueaderoApplication.class)
@Transactional
@Rollback(value=true)
public class VigilanteServicioTest {
	
	@Autowired
    VigilanteRepositorio vigilanteRepositorio;
	
	@Autowired
	VigilanteServicioImp vigilanteServico;
	
    
	@Before
	public void inicializacion() {
		
	}
	
    @Test
    public void validacionRespositorioSave() {
    	//Arrange
    	FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso("XXX123",TipoVehiculo.MOTO,new Date(),null,0,Estados.ACTIVO);
    	//Act
    	vigilanteServico.registrarVehiculo(fichaTecnica);
        long existeVehiculo = vigilanteRepositorio.existbyActivoYPlaca(fichaTecnica.getPlaca());
        //Assert
        Assert.assertEquals(1,existeVehiculo);
    	
    }
}
