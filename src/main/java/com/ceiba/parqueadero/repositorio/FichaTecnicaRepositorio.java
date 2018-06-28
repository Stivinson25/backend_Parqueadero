package com.ceiba.parqueadero.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;

public interface FichaTecnicaRepositorio extends JpaRepository<FichaTecnicaDeIngreso,Long> {
	
}
