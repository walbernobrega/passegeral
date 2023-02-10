package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Item;
import com.santanatextiles.services.ItemService;

@RestController
@RequestMapping(value="/item")
public class ItemResource {

	@Autowired
	private ItemService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long codigo) {
		
		Item obj = service.buscar(codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
