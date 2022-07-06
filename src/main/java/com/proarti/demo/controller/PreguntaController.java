package com.proarti.demo.controller;

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
import com.proarti.demo.entity.Pregunta;
import com.proarti.demo.servicios.PreguntaServicio;
import com.proarti.demo.servicios.ProyectoServicio;

@Controller
@RequestMapping("/pregunta")
public class PreguntaController {
	
	@Autowired
	PreguntaServicio preguntaSer;
	
	@Autowired
	ProyectoServicio proyectoSer;
	
	//Listar las preguntas de un articulo
	@GetMapping	("/{id}")
	public String listarPreguntas(@PathVariable int id, Model modelo) {
		
		//NOTA: REVISAR SI HAYA QUE ENVIAR EL OBJETO PROYECTO PARA MOSTAR EL NOMBRE //
		modelo.addAttribute("proyecto", proyectoSer.getProyecto(id));
		modelo.addAttribute("preguntas", preguntaSer.listarPreguntasDeArti(id));
		
		//RETORNAR EL HTML QUE MUESTRA LAS PREGUNTAS DE UN ARTICULO
		return "html/preguntas";
		
	}
	
	// visualizar Pregunta
	@GetMapping("/visualizar/{id}")
	public String verPregunta(@PathVariable int id, ModelMap model) {

		Pregunta pregunta = preguntaSer.getPregunta(id);

		model.addAttribute("pregunta", pregunta);

		// retornar el html que mouestra los proyectos
		return "html/verPregunta";
	}
	
	//mostrar interfaz de nuevA Pregunta
	@GetMapping("/nuevo/{id}")
	public String formPregunta(@PathVariable int id,Model model) {
		model.addAttribute("pregunta", new Pregunta());	
		model.addAttribute("proyecto", proyectoSer.getProyecto(id));
		//aca debe de ir el nombre del html que hace referencia a la interfaz de crear proyecto
		return "html/registrarPregunta";
	}
	
	//crear nuevo pregunta
	@PostMapping("/nuevo/")
	public String registrarPregunta(@Validated @ModelAttribute("pregunta")Pregunta pregunta, ModelMap model) {
		
		preguntaSer.guardarPregunta(pregunta);
		model.addAttribute("pregunta", new Pregunta());
		
		int idProyecto = pregunta.getProyecto().getId();
		
		//retornar el html que mouestra los articulos
		String cadena = "redirect:/pregunta/" + idProyecto;
		
		return cadena;
	}
	
	//mostar formulario de edicion
		@GetMapping("/editar/{id}")
		public String mostarFormEditar(@PathVariable int id, Model modelo) {
			
			Pregunta preguntaA= preguntaSer.getPregunta(id);
			
			modelo.addAttribute("pregunta", preguntaSer.getPregunta(id));
			int idProyecto = preguntaA.getProyecto().getId();
			modelo.addAttribute("proyecto", proyectoSer.getProyecto(idProyecto));
			//retornar el formulario de editar pregunta
			return "html/editarPregunta";
		}
		
		
		@PostMapping("/editar/{id}")
		public String actualizarPregunta(@PathVariable int id, @ModelAttribute("pregunta") Pregunta pregunta, Model model) {
			
		
			Pregunta preguntaActual = preguntaSer.getPregunta(id);
			int idProyecto = preguntaActual.getProyecto().getId();

			
			preguntaActual.setId(id);
			preguntaActual.setPreguntaa(pregunta.getPreguntaa());
			preguntaActual.setCadena(pregunta.getCadena());
			preguntaActual.setNotas(pregunta.getNotas());
			
			preguntaSer.guardarPregunta(preguntaActual);
			
			//retornar interfaz que muestra articulos
			
		
			String cadena = "redirect:/pregunta/" + idProyecto;
			System.out.println(cadena);

			return cadena;
		
			
		}
		
		@GetMapping("/eliminar/{id}")
		public String eliminarPregunta(@PathVariable int id) {
			int idProyecto = preguntaSer.getPregunta(id).getProyecto().getId();
			preguntaSer.eliminarPregunta(id);
			String cadena = "redirect:/pregunta/" + idProyecto;
			return cadena;
			
		}

}
