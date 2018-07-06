package com.ceiba.parqueadero;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.util.CalculadoraCobroParqueadero;
import com.ceiba.parqueadero.util.TipoVehiculo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FacturaTests {
	
	static final TipoVehiculo CARRO = TipoVehiculo.CARRO;
	static final TipoVehiculo MOTO = TipoVehiculo.MOTO;
	

	@Test
	public void cobro1HoraMoto(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,8,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(500,resultado);
	}
	
	@Test
	public void cobro2HoraMoto(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,9,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(1000,resultado);
	}
	@Test
	public void cobro3HoraMoto(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,10,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert		
		Assert.assertEquals(1500,resultado);
	}
	@Test
	public void cobro1DiaMoto(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,18,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert		
		Assert.assertEquals(4000,resultado); 
	}
	@Test
	public void cobro1DiaYHorasMoto(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,29,9,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(5000,resultado); 
	}
	@Test
	public void cobro3DiasMoto(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,30,18,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(12000,resultado); 
	}
	
	@Test
	public void cobro1HoraCarro(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,8,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(1000,resultado);
	}
	
	@Test
	public void cobro2HoraCarro(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,9,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert
		Assert.assertEquals(2000,resultado);
	}
	@Test
	public void cobro3HoraCarro(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,28,10,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert
		Assert.assertEquals(3000,resultado);
	}
	@Test
	public void cobro1DiaCarro(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime();
		Date fechaSalida = new GregorianCalendar(2018,6,28,18,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(8000,resultado); 
	}
	@Test
	public void cobro1DiaYHorasCarro(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,29,8,35).getTime(); 
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert
		Assert.assertEquals(9000,resultado); 
	}
	@Test
	public void cobro3DiasCarro(){	
		//arrange
		CalculadoraCobroParqueadero calculadoraCobroParqueadero = new CalculadoraCobroParqueadero();
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); 
		Date fechaSalida = new GregorianCalendar(2018,6,30,18,35).getTime();
		//act	
		long resultado=calculadoraCobroParqueadero.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(24000,resultado);
	}
}








