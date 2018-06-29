package com.ceiba.parqueadero.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.FichaTecnicaDeIngresoRepositorio;
import com.ceiba.parqueadero.util.Calculadora;
import com.ceiba.parqueadero.util.Estados;
import com.ceiba.parqueadero.util.RestResponse;
import com.ceiba.parqueadero.util.Validacion;

@Service
public class FichaTecnicaDeIngresoServicioImp implements FichaTecnicaDeIngresoServicio {
	
	@Autowired
	protected FichaTecnicaDeIngresoRepositorio fichaTecnicaDeIngresoRepositorio;

	@Override
	public void save(FichaTecnicaDeIngreso ftdi) {
		
		//if(!Validacion.validacionPlaca(ftdi)) {
			//throw new RestResponse("Los campos no estan diligenciados");
		//}
		ftdi.setFechaIngreso(Calculadora.fechaActual());
		ftdi.setEstado(Estados.ACTIVO);
		
	   this.fichaTecnicaDeIngresoRepositorio.save(ftdi);
	}
	
	
	

}
