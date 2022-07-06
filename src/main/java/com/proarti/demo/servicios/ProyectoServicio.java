package com.proarti.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proarti.demo.entity.Proyecto;
import com.proarti.demo.repository.ProyectoRepository;

@Service
public class ProyectoServicio {
	
	@Autowired
	ProyectoRepository proyectoR;
	
	
	//listar los proyectos de un usuario recibiendo la id del usuario
	public Iterable<Proyecto> listarNombreIdProyectos(int idU){		
		return proyectoR.listarProyectosUsuario(idU);		
}
	
	//obtener proyecto por id
	public Proyecto getProyecto(int id) {
		return proyectoR.findById(id).get();
	}
	
	//Guardar Proyecto
	public Proyecto guardarProyecto(Proyecto pro) {
		Proyecto proyecto = proyectoR.save(pro);
		return proyecto;
	}
	
	//Actualizar proyecto
	public Proyecto actualizarProyecto(Proyecto pro) {
		return proyectoR.save(pro);
	}
	
	
	//Eliminar proyecto
	public void eliminarProyecto(int id) {
		proyectoR.deleteById(id);
		
	}
	
	
	

}
