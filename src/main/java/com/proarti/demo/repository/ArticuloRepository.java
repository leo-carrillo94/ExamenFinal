package com.proarti.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proarti.demo.entity.Articulo;


@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {
	
	
	@Query(value = "SELECT * FROM articulo WHERE usuario_id=?1", nativeQuery = true)
	List<Articulo> listarArticulosUsuario(@Param("id") int id);



}
