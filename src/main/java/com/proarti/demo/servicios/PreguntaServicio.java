package com.proarti.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proarti.demo.entity.Pregunta;
import com.proarti.demo.repository.PreguntaRepository;

@Service
public class PreguntaServicio {

	@Autowired
	PreguntaRepository preguntaR;

	// listar las preguntas de un proyecto
	public Iterable<Pregunta> listarPreguntasDeArti(int idA) {
		return preguntaR.listarPreguntaArticulos(idA);
	}

	// obtener una pregunta
	public Pregunta getPregunta(int id) {
		return preguntaR.findById(id).get();
	}

	// Guardar Pregunta
	public Pregunta guardarPregunta(Pregunta pre) {
		return preguntaR.save(pre);
	}

	// Eliminar Arituclo
	public void eliminarPregunta(int id) {
		preguntaR.deleteById(id);

	}
}
