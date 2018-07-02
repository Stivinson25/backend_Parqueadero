package com.ceiba.parqueadero.controlador;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.servicio.FichaTecnicaDeIngresoServicio;
import com.ceiba.parqueadero.util.RestCorrecta;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FichaTecnicaDeIngresoControlador {

	@Autowired
	protected FichaTecnicaDeIngresoServicio fichaTecnicaDeIngresoServicio;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public RestCorrecta insert(@RequestBody FichaTecnicaDeIngreso ftdi) throws JsonParseException, JsonMappingException, IOException {		
		this.fichaTecnicaDeIngresoServicio.save(ftdi);
		return new RestCorrecta(HttpStatus.OK.value(),"operacion exitosa");
		
	}
	
	@RequestMapping(value="/facturar", method = RequestMethod.POST)
	public RestCorrecta facturar(@RequestBody FichaTecnicaDeIngreso ftdi) throws JsonParseException, JsonMappingException, IOException {		
		this.fichaTecnicaDeIngresoServicio.facturar(ftdi);
		return new RestCorrecta(HttpStatus.OK.value(),"operacion exitosa");
		
	}
	
}
