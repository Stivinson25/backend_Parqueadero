package com.ceiba.parqueadero.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.FichaTecnicaDeIngresoRepositorio;
import com.ceiba.parqueadero.util.Factura;
import com.ceiba.parqueadero.util.Estados;
import com.ceiba.parqueadero.util.RestIncorrecta;
import com.ceiba.parqueadero.util.Validacion;

@Service
public class FichaTecnicaDeIngresoServicioImp implements FichaTecnicaDeIngresoServicio {
	
	@Autowired
	protected FichaTecnicaDeIngresoRepositorio ftdiRepositorio;

	@Override
	public void save(FichaTecnicaDeIngreso ftdi) {
		
		FichaTecnicaDeIngreso ftdiBD= ftdiRepositorio.findbyActivoYPlaca(ftdi.getPlaca());
		
		//if(countActivoYTipo(ftdi.getTipoVehiculo())<20) {
			if(!Validacion.validacionPlaca(ftdi,ftdiBD)) {
				throw new RestIncorrecta("Los campos no estan diligenciados");
			}
		//}else throw new RestIncorrecta("No hay cupos disponibles");

		//ftdi.setFechaIngreso(Calculadora.fechaActual());
		//ftdi.setEstado(Estados.ACTIVO);
		//this.ftdiRepositorio.save(ftdi);
	}

	@Override
	public void facturar(FichaTecnicaDeIngreso ftdi) {
		FichaTecnicaDeIngreso ftdiBD= ftdiRepositorio.findbyActivoYPlaca(ftdi.getPlaca());
		long cobro= Factura.cobroParqueadero(ftdiBD.getTipoVehiculo(),Factura.fechaActual(),ftdiBD.getFechaIngreso());
		System.out.println(cobro);
		ftdiBD.setEstado(Estados.DESACTIVO);
		this.ftdiRepositorio.save(ftdiBD);
	}
	
	
	@Override
	public List<FichaTecnicaDeIngreso> findAll() {
		return this.ftdiRepositorio.findAll();
		
	}

	@Override
	public FichaTecnicaDeIngreso findbyActivoYPlaca(String verificarPlaca) {
		return this.ftdiRepositorio.findbyActivoYPlaca(verificarPlaca);
		
	}

	@Override
	public long countActivoYTipo(int tipo) {
		return this.countActivoYTipo(tipo);
	}


	
	
	

}
