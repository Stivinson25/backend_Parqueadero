package com.ceiba.parqueadero.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;

 public interface FichaTecnicaDeIngresoRepositorio extends JpaRepository<FichaTecnicaDeIngreso,Long> {

	 @SuppressWarnings("unchecked")
	 FichaTecnicaDeIngreso save(FichaTecnicaDeIngreso ftdi);
	
	 @Query(value = "SELECT * FROM parqueadero.ficha_tecnica_ingresos where estado='ACTIVO' and placa=:verificarPlaca",nativeQuery = true)
	 FichaTecnicaDeIngreso findbyActivoYPlaca(@Param("verificarPlaca") String verificarPlaca);

	 @Query(value = "SELECT count(*) FROM parqueadero.ficha_tecnica_ingresos where estado='ACTIVO' AND tipo_vehiculo=:tipo",nativeQuery = true)
	 long countActivoYTipo(@Param("tipo") int tipo);
	 
	 List<FichaTecnicaDeIngreso> findAll();
	
	
	
	
}
