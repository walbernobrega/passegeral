package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.services.PasseGeralService;

@RestController
@RequestMapping(value="/passegeral")
public class PasseGeralResource {

	@Autowired
	private PasseGeralService service; 
	
	@RequestMapping(value="/{numeroPasse}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String numeroPasse) {
		
		PasseGeral obj = service.buscar(numeroPasse);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
