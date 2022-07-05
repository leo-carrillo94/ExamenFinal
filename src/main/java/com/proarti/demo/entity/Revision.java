package com.proarti.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Revision {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Pregunta pregunta;
	
	@ManyToOne
	private Articulo articulo;

	@Column(columnDefinition = "TEXT")
	private String aporte;
	
	@CreationTimestamp
	private LocalDateTime fechacreacion;
	
	@Column(columnDefinition = "TEXT")
	private String notas;
	
	@Column(length = 1)
	private String estado;
	
	@Column(columnDefinition = "TEXT")
	private String razonexclusion;
	
	
	
	

	public Revision() {
		super();
	}

	public Revision(int id, Pregunta pregunta, Articulo articulo, String aporte, LocalDateTime fechacreacion,
			String notas, String estado, String razonexclusion) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.articulo = articulo;
		this.aporte = aporte;
		this.fechacreacion = fechacreacion;
		this.notas = notas;
		this.estado = estado;
		this.razonexclusion = razonexclusion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public String getAporte() {
		return aporte;
	}

	public void setAporte(String aporte) {
		this.aporte = aporte;
	}

	public LocalDateTime getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDateTime fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRazonexclusion() {
		return razonexclusion;
	}

	public void setRazonexclusion(String razonexclusion) {
		this.razonexclusion = razonexclusion;
	}
	
	

}
