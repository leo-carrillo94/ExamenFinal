package com.proarti.demo.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;


@Entity
public class Proyecto {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	@ManyToOne
	private Usuario usuario;
	
	@Column(length = 1000)
	private String titulo;
	
	@Column(columnDefinition = "TEXT")
	private String objetivo;
	
	@Column(columnDefinition = "TEXT")
	private String notas;
	
	private Date fechainicio;
	
	private Date fechafin;
	
	
	@ManyToOne
	private Estado estado;
	
	@CreationTimestamp
	private LocalDateTime fechacreacion;
	
	

	public Proyecto() {
	
	}

	public Proyecto(int id, Usuario usuario, String titulo, String objetivo, String notas, Date fechainicio,
			Date fechafin, Estado estado, LocalDateTime fechacreacion) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.objetivo = objetivo;
		this.notas = notas;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.estado = estado;
		this.fechacreacion = fechacreacion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public Date getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public LocalDateTime getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDateTime fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
	
	
	
	

}
