package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.ItemPasseGeral;
import com.santanatextiles.services.ItemPasseGeralService;

@RestController
@RequestMapping(value="/itempassegeral")
public class ItemPasseGeralResource {

	@Autowired
	private ItemPasseGeralService service; 
	
	@RequestMapping(value="/{numeroPasse}/{codigoItem}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String numeroPasse, @PathVariable String codigoItem) {
		
		ItemPasseGeral obj = service.buscar(numeroPasse,codigoItem); 
		
		return ResponseEntity.ok().body(obj);
		
	}

}
