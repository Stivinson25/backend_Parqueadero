package com.ceiba.parqueadero.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ceiba.parqueadero.util.Estados;

@Entity
@Table(name="ficha_tecnica_ingresos")
public class FichaTecnicaDeIngreso  implements Serializable{
	

	private static final long serialVersionUID = -4431929601983510578L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	private long id;
	
	@Column(name = "placa", nullable = false, length = 255)
	private String placa;
	
    @Column(name="tipo_vehiculo")
    private int tipoVehiculo;
	
	@Column(name = "fecha_ingreso", updatable=false, length = 255)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;
	
	@Column(name = "cilindraje")
	private int cilindraje;
	
    @Column(name="estado", length = 9 )
    @Enumerated(value = EnumType.STRING)
    private Estados estado;

        
	public FichaTecnicaDeIngreso() {
		super();
	}
		

	public FichaTecnicaDeIngreso(long id, String placa, int tipoVehiculo, Date fechaIngreso, int cilindraje,
			Estados estado) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipoVehiculo = tipoVehiculo;
		this.fechaIngreso = fechaIngreso;
		this.cilindraje = cilindraje;
		this.estado = estado;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(int tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}


	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}
    

}
