package com.ceiba.parqueadero.controlador;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parqueadero.modelo.Factura;
import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.servicio.VigilanteServicio;
import com.ceiba.parqueadero.util.RestCorrecta;

@RestController
public class VigilanteControlador {


	@Autowired
	@Qualifier("vigilanteServicioImp")
	VigilanteServicio vigilanteServicio;
	
	@RequestMapping(value="/registrarVehiculo", method = RequestMethod.POST)
	public RestCorrecta registrarVehiculo(@RequestBody FichaTecnicaDeIngreso fichaTecnica){		
		vigilanteServicio.registrarVehiculo(fichaTecnica);
		return new RestCorrecta(HttpStatus.OK.value(),"operacion exitosa");
	}
	
	@RequestMapping(value="/facturar", method = RequestMethod.POST)
	public Factura facturar(@RequestBody FichaTecnicaDeIngreso fichaTecnica){		
		return vigilanteServicio.facturar(fichaTecnica);
		
	}
	
	@RequestMapping(value="/listarVehiculos", method = RequestMethod.GET)
	public List<FichaTecnicaDeIngreso> ListarVehiculo(){		
		return this.vigilanteServicio.findAllEstadoActivo();
	}
	
}
