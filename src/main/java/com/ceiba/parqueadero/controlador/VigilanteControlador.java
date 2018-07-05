package com.ceiba.parqueadero.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.servicio.VigilanteServicio;
import com.ceiba.parqueadero.util.RestCorrecta;

@RestController
public class VigilanteControlador {


	@Autowired
	VigilanteServicio vigilanteServicio;
	
	@RequestMapping(value="/registrarVehiculo", method = RequestMethod.POST)
	public RestCorrecta registrarVehiculo(@RequestBody FichaTecnicaDeIngreso fichaTecnica){		
		this.vigilanteServicio.registrarVehiculo(fichaTecnica);
		return new RestCorrecta(HttpStatus.OK.value(),"operacion exitosa");
		
	}
	
	@RequestMapping(value="/facturar", method = RequestMethod.POST)
	public void facturar(@RequestBody FichaTecnicaDeIngreso ftdi){		
		//Factura factura = this.fichaTecnicaDeIngresoServicio.facturar(ftdi);
		//return new ResponseEntity<FichaTecnicaDeIngreso>(ftdi, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/listarVehiculos", method = RequestMethod.GET)
	public List<FichaTecnicaDeIngreso> ListarVehiculo(){		
		return this.vigilanteServicio.findAllEstadoActivo();
	}
	
}
