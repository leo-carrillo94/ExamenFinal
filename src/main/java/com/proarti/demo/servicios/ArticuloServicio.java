package com.proarti.demo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proarti.demo.entity.Articulo;
import com.proarti.demo.repository.ArticuloRepository;

@Service
public class ArticuloServicio {
	
	@Autowired
	ArticuloRepository articuloR;
	
	//listar los articulos de un usuario recibiendo la id del usuario
	public Iterable<Articulo> listarArticulosUsuario(int idU){		
		return articuloR.listarArticulosUsuario(idU);
}
	
	//obtener Articulo por id
		public Articulo getProyecto(int id) {
			return articuloR.findById(id).get();
		}
		
		//Guardar Articulo
		public Articulo guardarProyecto(Articulo arti) {
			return  articuloR.save(arti);
		}
		
		//Actualizar Articulo
		public Articulo actualizarProyecto(Articulo arti) {
			return articuloR.save(arti);
		}
		
		//Eliminar Arituclo
		public void eliminarArticulo(int id) {
			articuloR.deleteById(id);
			
		}

}
