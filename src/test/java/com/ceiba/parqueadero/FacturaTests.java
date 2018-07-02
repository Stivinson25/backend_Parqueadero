package com.ceiba.parqueadero;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.util.Factura;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacturaTests {
	
	static final int CARRO = 1;
	static final int MOTO = 2;
	

	@Test
	public void cobro1HoraMoto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,8,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(500,resultado);
	}
	
	@Test
	public void cobro2HoraMoto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,9,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(1000,resultado);
	}
	@Test
	public void cobro3HoraMoto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,10,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert		
		Assert.assertEquals(1500,resultado);
	}
	@Test
	public void cobro1DiaMoto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,18,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert		
		Assert.assertEquals(4000,resultado); 
	}
	@Test
	public void cobro1DiaYHorasMoto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,29,9,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(5000,resultado); 
	}
	@Test
	public void cobro3DiasMoto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,30,18,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(12000,resultado); 
	}
	
	@Test
	public void cobro1HoraCarro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,8,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(1000,resultado);
	}
	
	@Test
	public void cobro2HoraCarro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,9,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert
		Assert.assertEquals(2000,resultado);
	}
	@Test
	public void cobro3HoraCarro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,10,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert
		Assert.assertEquals(3000,resultado);
	}
	@Test
	public void cobro1DiaCarro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime();
		Date fechaSalida = new GregorianCalendar(2018,6,28,18,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(8000,resultado); 
	}
	@Test
	public void cobro1DiaYHorasCarro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,29,8,35).getTime(); 
		//act	
		long resultado=Factura.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert
		Assert.assertEquals(9000,resultado); 
	}
	@Test
	public void cobro3DiasCarro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,30,18,35).getTime();
		//act	
		long resultado=Factura.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(24000,resultado);
	}
}








