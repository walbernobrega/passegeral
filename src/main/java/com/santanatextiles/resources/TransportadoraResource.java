package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Transportadora;
import com.santanatextiles.services.TransportadoraService;

@RestController
@RequestMapping(value="/transportadora")
public class TransportadoraResource {

	@Autowired
	private TransportadoraService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String codigo) {
		
		Transportadora obj = service.buscar(codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
