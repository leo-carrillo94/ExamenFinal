package com.proarti.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.proarti.demo.entity.Usuario;
import com.proarti.demo.repository.UsuarioRepository;

@Service
public class UsuarioServicio {

	@Autowired
	UsuarioRepository usuarioR;
	
	@Autowired
	public BCryptPasswordEncoder encriptarContra;

	// Validar que el email no exista
	private boolean revisarEmail(Usuario user) throws Exception {
		Usuario usuarioE = usuarioR.findByEmail(user.getEmail());

		if (usuarioE != null) {
			throw new Exception("Correo de Usuario ya Existe");
		}
		return true;
	}

	// Crear usuario teniendo en cuenta la validacion del correo
	public Usuario crearUsuario(Usuario user) throws Exception {
		if (revisarEmail(user)) {
			
			user.setClave(encriptarContra.encode(user.getClave()));
			user = usuarioR.save(user);
		}
		return user;
	}
	//buscar usuario por email
	public Usuario findByUsername(String email) {
		 Usuario usuarioE = usuarioR.findByEmail(email);
		 
		 return usuarioE;

	}
	 
	// buscar el id del usuario teniendo su nombre
	public Integer idUsuarioPorNombre(String nombre) {
		Usuario user = usuarioR.findByNombre(nombre);
		return user.getId();
		
	}
	//buscar el nombre del usuario por el id
	public String nombrUsuario(int id) {
		return usuarioR.findById(id).get().getNombre();
		
	}

}
