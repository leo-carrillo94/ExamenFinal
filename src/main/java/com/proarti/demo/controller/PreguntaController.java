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
import org.springframework.web.bind.annotation.PutMapping;
import com.proarti.demo.entity.Pregunta;
import com.proarti.demo.servicios.PreguntaServicio;

@Controller
public class PreguntaController {
	
	@Autowired
	PreguntaServicio preguntaSer;
	
	//Listar las preguntas de un articulo
	@GetMapping	("/preguntas/{id}")
	public String listarPreguntas(@PathVariable int id, Model modelo) {
		
		//NOTA: REVISAR SI HAYA QUE ENVIAR EL OBJETO PROYECTO PARA MOSTAR EL NOMBRE //
		
		modelo.addAttribute("preguntas", preguntaSer.listarPreguntasDeArti(id));
		
		//RETORNAR EL HTML QUE MUESTRA LAS PREGUNTAS DE UN ARTICULO
		return null;
		
	}
	
	//mostrar interfaz de nuevA Pregunta
	@GetMapping("/nuevo")
	public String formPregunta(Model model) {
		model.addAttribute("pregunta", new Pregunta());	
		//aca debe de ir el nombre del html que hace referencia a la interfaz de crear proyecto
		return null;
	}
	
	//crear nuevo pregunta
	@PostMapping("/nuevo")
	public String registrarPregunta(@Validated @ModelAttribute("pregunta")Pregunta pregunta, ModelMap model) {
		
		preguntaSer.guardarPregunta(pregunta);
		model.addAttribute("pregunta", new Pregunta());		
		
		//retornar el html que mouestra los articulos
		return null;
	}
	
	//mostar formulario de edicion
		@GetMapping("/editar/{id}")
		public String mostarFormEditar(@PathVariable int id, Model modelo) {
			
			modelo.addAttribute("Pregunta", preguntaSer.getPregunta(id));
			
			//retornar el formulario de editar arituculo
			return null;
		}
		
		
		@PutMapping("/editar/{id}")
		public String actualizarPregunta(@PathVariable int id, @ModelAttribute("pregunta") Pregunta pregunta, Model model) {
			
			Pregunta preguntaActual = preguntaSer.getPregunta(id);
			
			preguntaActual.setId(id);
			preguntaActual.setPregunta(pregunta.getPregunta());
			preguntaActual.setCadena(pregunta.getCadena());
			preguntaActual.setNotas(pregunta.getNotas());
			
			preguntaSer.guardarPregunta(preguntaActual);
			
			//retornar interfaz que muestra articulos
			return null;
		
			
		}
		
		@GetMapping("/eliminar/{id}")
		public String eliminarPregunta(@PathVariable int id) {
			
			preguntaSer.eliminarPregunta(id);
			return null;
			
		}

}
