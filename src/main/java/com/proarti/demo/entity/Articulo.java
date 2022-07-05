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
public class Articulo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
		
	@ManyToOne
	private Usuario usuario;
	
	@Column(length = 500)
	private String titulo;
	
	@Column(length = 500)
	private String ano;
	
	@Column(length = 500)
	private String autores;
	
	@Column(length = 500)
	private String citacion;
	
	@ManyToOne
	private Pais pais;
		
	@Column(columnDefinition = "TEXT")
	private String resumen;
	
	@Column(columnDefinition = "TEXT")
	private String conclusiones;
	
	@Column(columnDefinition = "TEXT")
	private String vacio;
	
	@Column(length = 500)
	private String url;
	
	@Column(columnDefinition = "TEXT")
	private String notas;
	
	@CreationTimestamp
	private LocalDateTime fechacreacion;
	
	@Column(length = 200)
	private String revista;
	
	@Column(length = 50)
	private String categoria;
	
	@Column(length = 200)
	private String palabrasclave;
	

	public Articulo() {
	}

	public Articulo(int id, Usuario usuario, String titulo, String ano, String autores, String citacion, Pais pais,
			String resumen, String conclusiones, String vacio, String url, String notas, LocalDateTime fechacreacion,
			String revista, String categoria, String palabrasclave) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.ano = ano;
		this.autores = autores;
		this.citacion = citacion;
		this.pais = pais;
		this.resumen = resumen;
		this.conclusiones = conclusiones;
		this.vacio = vacio;
		this.url = url;
		this.notas = notas;
		this.fechacreacion = fechacreacion;
		this.revista = revista;
		this.categoria = categoria;
		this.palabrasclave = palabrasclave;
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

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public String getCitacion() {
		return citacion;
	}

	public void setCitacion(String citacion) {
		this.citacion = citacion;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getConclusiones() {
		return conclusiones;
	}

	public void setConclusiones(String conclusiones) {
		this.conclusiones = conclusiones;
	}

	public String getVacio() {
		return vacio;
	}

	public void setVacio(String vacio) {
		this.vacio = vacio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public LocalDateTime getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDateTime fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getRevista() {
		return revista;
	}

	public void setRevista(String revista) {
		this.revista = revista;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getPalabrasclave() {
		return palabrasclave;
	}

	public void setPalabrasclave(String palabrasclave) {
		this.palabrasclave = palabrasclave;
	}
	
	
	

	

	
	

}
