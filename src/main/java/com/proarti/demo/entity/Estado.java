package com.proarti.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estado {
	
	@Id
	@Column(length = 1)
	private String estado;
	
	@Column(length = 50)
	private String descripcion;
	
	

	public Estado() {
		super();
	}

	public Estado(String estado, String descripcion) {
		super();
		this.estado = estado;
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
