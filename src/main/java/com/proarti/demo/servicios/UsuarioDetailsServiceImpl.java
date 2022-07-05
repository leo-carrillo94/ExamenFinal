package com.proarti.demo.servicios;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proarti.demo.entity.Usuario;
import com.proarti.demo.repository.UsuarioRepository;

@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UsuarioRepository usuarioR;
	private Set grantList;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario appUser = usuarioR.findByEmail(email);

		
		grantList = new HashSet();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
		grantList.add(grantedAuthority);
		if (appUser != null) {
			UserDetails usuario = new User(email,appUser.getClave(), grantList);
			return usuario;
		}
		throw new UsernameNotFoundException("Usuario no Encontrado");
	}
	

}
