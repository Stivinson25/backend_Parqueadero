package com.ceiba.parqueadero.servicio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.modelo.Factura;
import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.repositorio.VigilanteRepositorio;
import com.ceiba.parqueadero.util.CalculadoraCobroParqueadero;
import com.ceiba.parqueadero.util.Estados;
import com.ceiba.parqueadero.util.TipoVehiculo;


@Service("vigilanteServicioImp")
public class VigilanteServicioImp implements VigilanteServicio{
	
	@Autowired
	@Qualifier("vigilanteRepositorio")
	VigilanteRepositorio vigilanteRepositorio;
	
	@Autowired
	@Qualifier("validacionIngresoServicioImp")
	ValidacionIngresoServicioImp validacionIngreso;
	
	@Autowired
	@Qualifier("validacionSalidaServicioImp")
	ValidacionSalidaServicioImp validacionSalida;
	

	@Override
	public void registrarVehiculo(FichaTecnicaDeIngreso fichaTecnica) {
	
		validacionIngreso.validar(fichaTecnica);
		fichaTecnica.setFechaIngreso(new Date());
		fichaTecnica.setEstado(Estados.ACTIVO);
		vigilanteRepositorio.save(fichaTecnica);
	}

	@Override
	public Factura facturar(FichaTecnicaDeIngreso fichaTecnica) {
		
		long valorApagar=0;
		CalculadoraCobroParqueadero cobro= new CalculadoraCobroParqueadero();
		FichaTecnicaDeIngreso fichaTecnicaBD=new FichaTecnicaDeIngreso();
		
		fichaTecnicaBD=validacionSalida.validacionPlaca(fichaTecnica);
		
		Date fechaSalida=new Date();
		fichaTecnicaBD.setFechaSalida(fechaSalida);
		fichaTecnicaBD.setEstado(Estados.DESACTIVO);
		vigilanteRepositorio.save(fichaTecnicaBD);
		
		valorApagar=cobro.cobroParqueadero(fichaTecnicaBD.getTipoVehiculo(),fechaSalida,fichaTecnicaBD.getFechaIngreso());
		
		return new Factura(fichaTecnicaBD.getPlaca(), fichaTecnicaBD.getTipoVehiculo(), valorApagar);
	}
	
	
	@Override
	public List<FichaTecnicaDeIngreso> findAllEstadoActivo() {
		return vigilanteRepositorio.findAllEstadoActivo();
		
	}

	@Override
	public long findbyActivoYPlaca(String verificarPlaca) {
		return vigilanteRepositorio.existbyActivoYPlaca(verificarPlaca);
		
	}

	@Override
	public long countActivoYTipo(TipoVehiculo tipo) {
		return countActivoYTipo(tipo);
	}


	
	
	

}
