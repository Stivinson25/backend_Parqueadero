package com.ceiba.parqueadero.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;

public interface FichaTecnicaDeIngresoRepositorio extends JpaRepository<FichaTecnicaDeIngreso,Long> {
	
	@SuppressWarnings("unchecked")
	FichaTecnicaDeIngreso save(FichaTecnicaDeIngreso ftdi);
	
}
