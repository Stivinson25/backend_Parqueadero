package com.ceiba.parqueadero.util;

import java.util.Date;


public class Factura {
	
	public Factura() {
		super();
	}

	static final int HORA_CARRO = 1000;
	static final int DIA_CARRO = 8000;
	static final int HORA_MOTO = 500;
	static final int DIA_MOTO = 4000;
	

	public static long cobroParqueadero(int tipo, Date fechaActual, Date fechaIngreso) {
		
		int cobroHora;
		int cobroDia;
		
		if(tipo == 1) {
			cobroHora=HORA_CARRO;
			cobroDia=DIA_CARRO;
		}else {
			cobroHora=HORA_MOTO;
			cobroDia=DIA_MOTO;
		}
	    return calcularPago(fechaActual, fechaIngreso, cobroHora, cobroDia);
		
	}

	public static long calcularPago(Date fechaActual, Date fechaIngreso, int cobroHora, int cobroDia) {
		long pago=0;
	    long dias=0;
	    long horas=((fechaActual.getTime()-fechaIngreso.getTime())/1000)/3600;
	    
	    if(horas<=9) {
	    	pago = horas*cobroHora;
	    }else if(horas>9 && horas <24) {
	    	return cobroDia;
	    }else if(horas>=24){
	    	dias = horas/24;
	    	horas= horas%24;
	    	if(horas>9 && horas <24) {
	    		return dias*cobroDia + cobroDia;	
	    	}else {
	    		pago = dias*cobroDia + horas*cobroHora;
	    	}
	    		
	    }
	    	
	    return  pago + cobroHora;
	}

	
	public static Date fechaActual() {		
		return new Date();
	}
	
	

}
