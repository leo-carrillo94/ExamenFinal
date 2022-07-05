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

import com.proarti.demo.entity.Proyecto;
import com.proarti.demo.repository.EstadoRepository;
import com.proarti.demo.servicios.ProyectoServicio;
import com.proarti.demo.servicios.UsuarioServicio;

@Controller
@RequestMapping("/proyectos")
public class ProyectoController {
	
	@Autowired
	ProyectoServicio proyectoSer;
	
	@Autowired
	UsuarioServicio usuarioSer;
	
	@Autowired
	EstadoRepository estadoR;
	
	
	//mostrar interfaz de nuevo Proyecto
	@GetMapping("/nuevo")
	public String formProyecto(Model model) {
		model.addAttribute("proyecto", new Proyecto());
		
		//aca debe de ir el nombre del html que hace referencia a la interfaz de crear proyecto
		return null;
	}
	
	//crear nuevo proyecto
	@PostMapping("/nuevo")
	public String registrarProyecto(@Validated @ModelAttribute("proyecto")Proyecto proyecto, ModelMap model) {
		
		System.out.println("entro aal post");
		
		proyectoSer.guardarProyecto(proyecto);
		model.addAttribute("proyecto", new Proyecto());		
		
		//retornar el html que mouestra los proyectos
		return null;
	}
	
	
	//visualizar proyecto
		@GetMapping("/visualizar/{id}")
		public String verProyecto(@PathVariable int id, ModelMap model) {
			
			Proyecto proyecto = proyectoSer.getProyecto(id);

			model.addAttribute("proyecto", proyecto);		
			
			//retornar el html que mouestra los proyectos
			return null;
		}
	
	
	
	
	
	//listar los proyectos del usuario, recibimos la id y el nombre para hacer una validacion
	@GetMapping("/{id}/{nombres}")
	public String formProyectos(@PathVariable Map<String, String> variables, Model modelo) {
		
		String id = variables.get("id");
		Integer  a = Integer.parseInt(id);
		String nombre = variables.get("nombres");
		
		if(a == usuarioSer.idUsuarioPorNombre(nombre)) {
			System.out.println("entro al if");

			modelo.addAttribute("proyectos", proyectoSer.listarNombreIdProyectos(a));
			
			//para listar los estados que se encuentran en la BD
			modelo.addAttribute("estados", estadoR.findAll());
			
			//retornar el html que mouestra los proyectos
			return "html/proyectos";		
		}		
		return "html/dashboard";
	}
	
	//mostar formulario de edicion
	@GetMapping("/editar/{id}")
	public String mostarFormEditar(@PathVariable int id, Model modelo) {
		
		modelo.addAttribute("proyecto", proyectoSer.getProyecto(id));
		
		//retornar el formulario de editar
		return null;
		
	}
	
	@PutMapping("/editar/{id}")
	public String actualizarProyecto(@PathVariable int id, @ModelAttribute("proyecto") Proyecto proyecto, Model model) {
		
		Proyecto proyectoActual = proyectoSer.getProyecto(id);
		
		proyectoActual.setId(id);
		proyectoActual.setTitulo(proyecto.getTitulo());
		proyectoActual.setObjetivo(proyecto.getObjetivo());
		proyectoActual.setNotas(proyecto.getNotas());
		proyectoActual.setFechainicio(proyecto.getFechainicio());
		proyectoActual.setFechafin(proyecto.getFechafin());
		proyectoActual.setEstado(proyecto.getEstado());
		
		proyectoSer.actualizarProyecto(proyectoActual);
		
		
		return null;
	
		
	}
	
	@GetMapping("/eliminar/{id}/{idU}")
	public String eliminarProyecto(@PathVariable Map<String, String> variables) {
		
		String id = variables.get("id");
		Integer  a = Integer.parseInt(id);
		
		String idU = variables.get("idU");
		Integer  b = Integer.parseInt(idU);
		
		proyectoSer.eliminarProyecto(a);
		
		String nombre= usuarioSer.nombrUsuario(b);
		 
		String cadena = "redirect:/proyectos/"+b+"/"+nombre;
		
		return cadena;
		
	}
	
	
	

}
