package com.proarti.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 50)
	private String nombre;

	@Column(length = 100, unique = true)
	private String email;

	@Column(length = 300)
	private String clave;

	@Column(length = 50)
	private String pais;

	@Column(length = 200)
	private String entidad;

	@Column(length = 1)
	private String estado;

	public Usuario() {

	}

	public Usuario(int id, String nombre, String email, String clave, String pais, String entidad, String estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.clave = clave;
		this.pais = pais;
		this.entidad = entidad;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
