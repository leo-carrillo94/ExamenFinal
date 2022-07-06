package com.proarti.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proarti.demo.entity.Usuario;
import com.proarti.demo.repository.PaisRepository;
import com.proarti.demo.servicios.UsuarioServicio;



@Controller
public class UsuarioController {
	
	
	@Autowired
	UsuarioServicio usuarioSer;
	
	@Autowired
	PaisRepository paisRepo;

	// Mostrar inicio, login
	@GetMapping({"/","/login"})
	public String getLogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "index";

	}
	
	// Mostrar dashboard
		@GetMapping("/dashboard")
		public String dashboard(Authentication auth, HttpSession session) {
			
			String username = auth.getName();
			System.out.println("consulta dash");
			System.out.println(username);
			
			if (session.getAttribute("usuario")==null) {
					Usuario usuario = usuarioSer.findByUsername(username);
					usuario.setClave(null);
					session.setAttribute("usuario", usuario);
				
			}
			
			System.out.println("va para el dashboard");
			return "html/dashboard";
		}

	// mostrar formulario de Registro
	@GetMapping("/registro")
	public String getFormulario(Model modelo) {
		modelo.addAttribute("usuarioForm", new Usuario());
		return "html/registro";
	}
	
	@PostMapping("/registro")
	public String crearUsuario(@Validated @ModelAttribute("usuarioForm") Usuario usuario, BindingResult result,
			ModelMap model)  {
		{

			if (result.hasErrors()) {
				model.addAttribute("usuarioForm", usuario);
			} else {
				
					try {
						String alerta = "Registro Exitoso";
						usuarioSer.crearUsuario(usuario);
						model.addAttribute("alertR", alerta);
						return "index";
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						model.addAttribute("errorForm", e.getMessage());
					}
					model.addAttribute("usuarioForm", new Usuario());
				
			}
		}
		return "html/registro";
	}
	
	
	

}
