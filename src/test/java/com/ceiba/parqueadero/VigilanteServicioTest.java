package com.ceiba.parqueadero;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.validateMockitoUsage;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.servicio.VigilanteServicio;
import com.ceiba.parqueadero.servicio.VigilanteServicioImp;
import com.ceiba.parqueadero.util.Estados;
import com.ceiba.parqueadero.util.TipoVehiculo;
import com.ceiba.parqueadero.util.ValidacionIngreso;

@RunWith(SpringRunner.class)
@DataJpaTest 
public class VigilanteServicioTest {
	
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private VigilanteRepositorio vigilanteRepositorio;
    
    VigilanteServicio vigilanteServicio;
    
    ValidacionIngreso validacionIngreso;
    
	@Before
	public void inicializacion() {
		vigilanteServicio = new VigilanteServicioImp(vigilanteRepositorio);
		validacionIngreso= new ValidacionIngreso(vigilanteRepositorio);
	}
    
    @Test
    public void validacionRespositorioSave() {
        // given
    	FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso("XXX123",TipoVehiculo.MOTO,new Date(),null,0,Estados.ACTIVO);
     
        // when
        FichaTecnicaDeIngreso fichaTecnicaDeIngreso = vigilanteRepositorio.save(fichaTecnica);
     
        // then
        assertThat(fichaTecnicaDeIngreso.getPlaca()).isEqualTo(fichaTecnica.getPlaca());
    }
	
    @Test
    public void validacionRepositoriofindByActivoYPlacaTest() {
        // given
    	FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso("XXX123",TipoVehiculo.MOTO,new Date(),null,0,Estados.ACTIVO);
        FichaTecnicaDeIngreso fichaTecnicaDeIngreso = vigilanteRepositorio.save(fichaTecnica);
     
        // when
        long existeVehiculo = vigilanteRepositorio.findbyActivoYPlaca(fichaTecnica.getPlaca());
     
        // then
        Assert.assertEquals(1,existeVehiculo); 
    }
    
    @Test
    public void validacionRegistroVehiculoTest() {
		//arrange	
		FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso("XXX123",TipoVehiculo.MOTO,new Date(),null,0,Estados.ACTIVO);
		//act	
	    vigilanteServicio.registrarVehiculo(fichaTecnica);
		//Assert
		assertEquals(1,vigilanteServicio.findbyActivoYPlaca(fichaTecnica.getPlaca()));
    }

}
