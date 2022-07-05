package com.proarti.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.proarti.demo.entity.Articulo;
import com.proarti.demo.repository.PaisRepository;
import com.proarti.demo.servicios.ArticuloServicio;
import com.proarti.demo.servicios.UsuarioServicio;

@Controller
@RequestMapping("/articulos")
public class ArticuloController {
	
	@Autowired
	ArticuloServicio articuloSer;
	@Autowired
	UsuarioServicio usuarioSer;
	
	@Autowired
	PaisRepository paisR;
	
	//listar los Arituclos del usuario, recibimos la id y el nombre para hacer una validacion
	@GetMapping("/{id}/{nombres}")
	public String listarArticulos(@PathVariable Map<String, String> variables, Model modelo) {
		
		String id = variables.get("id");
		Integer  a = Integer.parseInt(id);
		String nombre = variables.get("nombres");
		
		if(a == usuarioSer.idUsuarioPorNombre(nombre)) {

			modelo.addAttribute("articulos", articuloSer.listarArticulosUsuario(a));
			modelo.addAttribute("paises", paisR.findAll());
			
			//retornar el html que mouestra los articulos
			return null;		
		}		
		return "/html/dashboard";
	}
	
	//mostrar interfaz de nuevo Articulo
	@GetMapping("/nuevo")
	public String formArticulo(Model model) {
		model.addAttribute("articulo", new Articulo());	
		//aca debe de ir el nombre del html que hace referencia a la interfaz de crear proyecto
		return null;
	}
	
	
	//crear nuevo articulo
	@PostMapping("/nuevo")
	public String registrarArticulo(@Validated @ModelAttribute("articulo")Articulo articulo, ModelMap model) {
		
		articuloSer.guardarProyecto(articulo);
		model.addAttribute("articulo", new Articulo());		
		
		//retornar el html que mouestra los articulos
		return null;
	}
	
	//mostar formulario de edicion
	@GetMapping("/editar/{id}")
	public String mostarFormEditar(@PathVariable int id, Model modelo) {
		
		modelo.addAttribute("arituclo", articuloSer.getProyecto(id));
		
		//retornar el formulario de editar arituculo
		return null;
		
	}
	
	@PutMapping("/editar/{id}")
	public String actualizarArticulo(@PathVariable int id, @ModelAttribute("articulo") Articulo articulo, Model model) {
		
		Articulo articuloActual = articuloSer.getProyecto(id);
		
		articuloActual.setId(id);
		articuloActual.setTitulo(articulo.getTitulo());
		articuloActual.setAno(articulo.getAno());
		articuloActual.setAutores(articulo.getAutores());
		articuloActual.setCitacion(articulo.getCitacion());
		articuloActual.setPais(articulo.getPais());
		articuloActual.setResumen(articulo.getResumen());
		articuloActual.setConclusiones(articulo.getConclusiones());
		articuloActual.setVacio(articulo.getVacio());
		articuloActual.setUrl(articulo.getUrl());
		articuloActual.setNotas(articulo.getNotas());
		articuloActual.setRevista(articulo.getRevista());
		articuloActual.setCategoria(articulo.getCategoria());
		articuloActual.setPalabrasclave(articulo.getPalabrasclave());
		
		articuloSer.actualizarProyecto(articuloActual);
		
		//retornar interfaz que muestra articulos
		return null;
	
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarArticulo(@PathVariable int id) {
		
		articuloSer.eliminarArticulo(id);
		
		return null;
		
	}
	

}
