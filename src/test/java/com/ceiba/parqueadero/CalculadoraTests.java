package com.ceiba.parqueadero;

import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ceiba.parqueadero.util.Calculadora;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculadoraTests {
	
	static final int CARRO = 1;
	static final int MOTO = 2;
	

	@Test
	public void cobro_1_hora_moto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,28,8,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(500,resultado);
	}
	
	@Test
	public void cobro_2_hora_moto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,28,9,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(1000,resultado);
	}
	@Test
	public void cobro_3_hora_moto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,28,10,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert		
		Assert.assertEquals(1500,resultado);
	}
	@Test
	public void cobro_1_dia_moto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,28,18,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert		
		Assert.assertEquals(4000,resultado); 
	}
	@Test
	public void cobro_1_dia_horas_moto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,29,9,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(5000,resultado); 
	}
	@Test
	public void cobro_3_dia_moto(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,30,18,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(MOTO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(12000,resultado); 
	}
	////// //////////////////////////////   Pruebas carro
	
	@Test
	public void cobro_1_hora_carro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,28,8,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(1000,resultado);
	}
	
	@Test
	public void cobro_2_hora_carro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,28,9,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert
		Assert.assertEquals(2000,resultado);
	}
	@Test
	public void cobro_3_hora_carro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,28,10,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert
		Assert.assertEquals(3000,resultado);//fecha ingreso 7:04am
	}
	@Test
	public void cobro_1_dia_carro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,28,18,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(8000,resultado); 
	}
	@Test
	public void cobro1_dia_horas_carro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,29,8,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert
		Assert.assertEquals(9000,resultado); 
	}
	@Test
	public void cobro_3_dia_carro(){	
		//arrange
		Date fechaIngreso = new GregorianCalendar(2018,6,28,7,55).getTime(); //yyyy/mm/dd/HH/mm
		Date fechaSalida = new GregorianCalendar(2018,6,30,18,35).getTime(); //yyyy/mm/dd/HH/mm
		//act	
		long resultado=Calculadora.cobroParqueadero(CARRO,fechaSalida,fechaIngreso);
		//assert	
		Assert.assertEquals(24000,resultado);
	}
}








