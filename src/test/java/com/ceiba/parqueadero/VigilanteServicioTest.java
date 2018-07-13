package com.ceiba.parqueadero;

import static org.junit.Assert.assertEquals;
import java.util.Date;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.modelo.Factura;
import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.servicio.VigilanteServicioImp;
import com.ceiba.parqueadero.util.Constante;
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
    public void validacionRegistroDeVehiculo() {
    	//Arrange
    	FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso("XXX123",TipoVehiculo.MOTO,new Date(),null,0,Estados.ACTIVO);
    	//Act
    	vigilanteServico.registrarVehiculo(fichaTecnica);
        long existeVehiculo = vigilanteRepositorio.existbyActivoYPlaca(fichaTecnica.getPlaca());
        //Assert
        Assert.assertEquals(Constante.EXISTE_VEHICULO,existeVehiculo);	
    }
    
    @Test
    public void validacionFactura() {
    	//Arrange
    	FichaTecnicaDeIngreso fichaTecnica = new FichaTecnicaDeIngreso("XXX123",TipoVehiculo.MOTO,new Date(),null,0,Estados.ACTIVO);
    	vigilanteServico.registrarVehiculo(fichaTecnica);
    	Factura valorACobrar = new Factura("XXX123", TipoVehiculo.MOTO,Constante.HORA_MOTO);
    	//Act
    	Factura factura=vigilanteServico.facturar(fichaTecnica);
        //Assert
        assertEquals(valorACobrar,factura);	
    }
}
