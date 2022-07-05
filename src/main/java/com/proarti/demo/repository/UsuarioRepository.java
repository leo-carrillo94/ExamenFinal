package com.proarti.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proarti.demo.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	//Buscar usuario por nombre de Usuario
	Usuario findByEmail(String email);

		//Buscar usuario por nombre
	Usuario findByNombre(String nombre);

}
