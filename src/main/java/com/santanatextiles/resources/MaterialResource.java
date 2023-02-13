package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Material;
import com.santanatextiles.services.MaterialService;

@RestController
@RequestMapping(value="/material")
public class MaterialResource {

	@Autowired
	private MaterialService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long codigo) {
		
		Material obj = service.buscar(codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
