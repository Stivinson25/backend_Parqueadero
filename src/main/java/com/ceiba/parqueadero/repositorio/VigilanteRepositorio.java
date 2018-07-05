package com.ceiba.parqueadero.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ceiba.parqueadero.modelo.FichaTecnicaDeIngreso;
import com.ceiba.parqueadero.util.TipoVehiculo;

@Repository("vigilanteRepositorio")
public interface VigilanteRepositorio extends JpaRepository<FichaTecnicaDeIngreso,Long> {

	 @SuppressWarnings("unchecked")
	 FichaTecnicaDeIngreso save(FichaTecnicaDeIngreso fichaTecnicaDeIngreso);
	
	 @Query(value = "SELECT count(*) FROM parqueadero.ficha_tecnica_ingresos where estado='ACTIVO' AND placa=:placa", nativeQuery = true)
	 long findbyActivoYPlaca(@Param("placa") String placa);

	 @Query(value = "SELECT count(*) FROM parqueadero.ficha_tecnica_ingresos where estado='ACTIVO' AND tipo_vehiculo=:tipo",nativeQuery = true)
	 long countActivoYTipo(@Param("tipo") TipoVehiculo tipo);
	 
	 @Query(value = "SELECT * FROM parqueadero.ficha_tecnica_ingresos where estado='ACTIVO'",nativeQuery = true)
	 List<FichaTecnicaDeIngreso> findAllEstadoActivo();	
	
}
