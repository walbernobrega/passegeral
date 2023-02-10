package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Gerente;
import com.santanatextiles.services.GerenteService;

@RestController
@RequestMapping(value="/gerente")
public class GerenteResource {

	@Autowired
	private GerenteService service; 
	
	@RequestMapping(value="/{matricula}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String matricula) {
		
		Gerente obj = service.buscar(matricula);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
