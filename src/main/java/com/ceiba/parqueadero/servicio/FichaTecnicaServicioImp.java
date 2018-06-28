package com.ceiba.parqueadero.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.parqueadero.repositorio.FichaTecnicaRepositorio;

@Service
public class FichaTecnicaServicioImp implements FichaTecnicaServicio {
	
	@Autowired
	protected FichaTecnicaRepositorio fichaTecnicaRepositorio;

}
