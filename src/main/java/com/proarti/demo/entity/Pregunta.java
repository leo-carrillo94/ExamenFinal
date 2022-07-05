package com.proarti.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Proyecto proyecto;

	@Column(columnDefinition = "TEXT")
	private String pregunta;

	@Column(columnDefinition = "TEXT")
	private String cadena;

	@Column(columnDefinition = "TEXT")
	private String notas;

	public Pregunta() {
		super();
	}

	public Pregunta(int id, Proyecto proyecto, String pregunta, String cadena, String notas) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.pregunta = pregunta;
		this.cadena = cadena;
		this.notas = notas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

}
