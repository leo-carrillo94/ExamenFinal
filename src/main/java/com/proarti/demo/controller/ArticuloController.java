package com.proarti.demo.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String listarArticulos(@PathVariable Map<String, String> variables, Model modelo, HttpSession session) {
		
		String id = variables.get("id");
		Integer  a = Integer.parseInt(id);
		String nombre = variables.get("nombres");
		
		
		if(a == usuarioSer.idUsuarioPorNombre(nombre)) {

			modelo.addAttribute("articulos", articuloSer.listarArticulosUsuario(a));
			modelo.addAttribute("paises", paisR.findAll());
			session.setAttribute("usuario", usuarioSer.obtenerUsuario(a));
			
			//retornar el html que mouestra los articulos
			return "html/articulos";		
		}		
		return "/html/dashboard";
	}
	
	//mostrar interfaz de nuevo Articulo
	@GetMapping("/nuevo/{id}")
	public String formArticulo(@PathVariable int id,Model model, HttpSession session) {
		model.addAttribute("articulo", new Articulo());	
		model.addAttribute("paises", paisR.findAll());
		session.setAttribute("usuario", usuarioSer.obtenerUsuario(id));
		//aca debe de ir el nombre del html que hace referencia a la interfaz de crear proyecto
		return "html/registroArticulo";
	}
	
	
	//crear nuevo articulo
	@PostMapping("/nuevo")
	public String registrarArticulo(@Validated @ModelAttribute("articulo")Articulo articulo, ModelMap model) {
		
		articuloSer.guardarProyecto(articulo);
		model.addAttribute("articulo", new Articulo());		
		
		//retornar el html que mouestra los articulos
		return "html/dashboard";
	}
	
	//mostar formulario de edicion
	@GetMapping("/editar/{id}")
	public String mostarFormEditar(@PathVariable int id, Model modelo) {
		
		modelo.addAttribute("articulo", articuloSer.getProyecto(id));
		
		//retornar el formulario de editar arituculo
		return "html/editarArticulo";
		
	}
	
	// visualizar articulo
	@GetMapping("/visualizar/{id}")
	public String verArticulo(@PathVariable int id, ModelMap model) {

		Articulo articulo = articuloSer.getProyecto(id);

		model.addAttribute("articulo", articulo);

		// retornar el html que mouestra los proyectos
		return "html/verArticulo";
	}
	
	@PostMapping("/editar/{id}")
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
		int idUsuario = articuloActual.getUsuario().getId();
		String nombreUsuario = articuloActual.getUsuario().getNombre();
		String cadena = "redirect:/articulos/" + idUsuario + "/" + nombreUsuario;
		System.out.println(cadena);

		return cadena;
	
		
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarArticulo(@PathVariable int id) {
		
	
		String nombre = articuloSer.getProyecto(id).getUsuario().getNombre();
		int idUsuario = articuloSer.getProyecto(id).getUsuario().getId();
		articuloSer.eliminarArticulo(id);
		String cadena = "redirect:/articulos/" + idUsuario + "/" + nombre;

		return cadena;
		
	}
	

}
