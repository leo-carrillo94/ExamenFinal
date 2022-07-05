package com.proarti.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proarti.demo.entity.Proyecto;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Integer> {
	
	//consultas NATIVAS de SQL 
	@Query(value = "SELECT * FROM proyecto WHERE usuario_id=?1", nativeQuery = true)
	List<Proyecto> listarProyectosUsuario(@Param("id") int id);


}
