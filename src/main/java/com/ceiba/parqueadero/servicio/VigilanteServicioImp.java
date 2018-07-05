package com.ceiba.parqueadero.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.util.Estados;
import com.ceiba.parqueadero.util.TipoVehiculo;
import com.ceiba.parqueadero.util.ValidacionIngreso;

@Service
public class VigilanteServicioImp implements VigilanteServicio {
	
	@Autowired
	private VigilanteRepositorio vigilanteRepositorio;
	
	@Autowired
	ValidacionIngreso validacion;

	@Override
	public void registrarVehiculo(FichaTecnicaDeIngreso fichaTecnica) {
	
		validacion.validacionPlaca(fichaTecnica);
		fichaTecnica.setFechaIngreso(new Date());
		fichaTecnica.setEstado(Estados.ACTIVO);
		vigilanteRepositorio.save(fichaTecnica);
	}

	@Override
	public long facturar(FichaTecnicaDeIngreso fichaTecnica) {

		
		return 0;
	}
	
	
	@Override
	public List<FichaTecnicaDeIngreso> findAllEstadoActivo() {
		return vigilanteRepositorio.findAllEstadoActivo();
		
	}

	@Override
	public long findbyActivoYPlaca(String verificarPlaca) {
		return vigilanteRepositorio.findbyActivoYPlaca(verificarPlaca);
		
	}

	@Override
	public long countActivoYTipo(TipoVehiculo tipo) {
		return countActivoYTipo(tipo);
	}


	
	
	

}
