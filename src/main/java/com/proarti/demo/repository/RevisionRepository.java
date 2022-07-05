package com.proarti.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.proarti.demo.entity.Revision;

@Repository
public interface RevisionRepository extends JpaRepository<Revision, Integer> {
	
	
	//buscar preguntas por id del proyecto
		@Query(value = "SELECT * FROM revision WHERE pregunta_id=?1", nativeQuery = true)
		List<Revision> listarRevisionPregArti(@Param("id") int id);

}
