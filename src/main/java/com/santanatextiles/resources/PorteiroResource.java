package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.services.PorteiroService;

@RestController
@RequestMapping(value="/porteiro")
public class PorteiroResource {

	@Autowired
	private PorteiroService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String codigo) {
		
		Porteiro obj = service.buscar(codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
