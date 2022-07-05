package com.proarti.demo.servicios;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proarti.demo.entity.Articulo;
import com.proarti.demo.entity.Revision;
import com.proarti.demo.repository.ArticuloRepository;
import com.proarti.demo.repository.RevisionRepository;

@Service
public class RevisionServicio {
	
	@Autowired
	RevisionRepository revisionR;
	@Autowired
	ArticuloRepository articuloR;
	
	
	//listar la revision de acuerdo a una pregunta para luego listar cada artigulo Relacionado
	public Iterable<Articulo> listarArticulosRevision(int idA) {
		//return preguntaR.listarPreguntaArticulos(idA);
		
		List<Revision> revision = revisionR.listarRevisionPregArti(idA);
		
		List<Articulo> articulos = new ArrayList<>();
		
		for (Revision revision2 : revision) {
			
			//obtener el id del articulo relacionado a cada revision
			int idArticulo = revision2.getArticulo().getId();
			
			//obtener el articulo
			Articulo a = articuloR.getById(idArticulo);
			
			//agg el articulo al array de articulos
			articulos.add(a);
						
		}
		
		return articulos;
		
	}
	

}
