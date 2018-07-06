package com.ceiba.parqueadero.util;

import java.util.Date;


public class CalculadoraCobroParqueadero {
	
	public CalculadoraCobroParqueadero() {
		super();
	}


	public long cobroParqueadero(TipoVehiculo tipo, Date fechaActual, Date fechaIngreso) {
		
		int cobroHora;
		int cobroDia;
		
		if(tipo == TipoVehiculo.CARRO) {
			cobroHora=Constante.HORA_CARRO;
			cobroDia=Constante.DIA_CARRO;
		}else {
			cobroHora=Constante.HORA_MOTO;
			cobroDia=Constante.DIA_MOTO;
		}
	    return calcularPago(fechaActual, fechaIngreso, cobroHora, cobroDia);
		
	}

	public long calcularPago(Date fechaActual, Date fechaIngreso, int cobroHora, int cobroDia) {
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

}
