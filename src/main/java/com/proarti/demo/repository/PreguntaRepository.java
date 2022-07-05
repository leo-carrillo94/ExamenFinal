package com.proarti.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proarti.demo.entity.Pregunta;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {
	
	//buscar preguntas por id del proyecto
	@Query(value = "SELECT * FROM pregunta WHERE proyecto_id=?1", nativeQuery = true)
	List<Pregunta> listarPreguntaArticulos(@Param("id") int id);


}
