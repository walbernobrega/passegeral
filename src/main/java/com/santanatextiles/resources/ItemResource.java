package com.santanatextiles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Item;
import com.santanatextiles.services.ItemService;
import com.santanatextiles.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/item")
public class ItemResource {

	@Autowired
	private ItemService service; 
	
	@CrossOrigin
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long codigo) {
		
		Item obj = service.buscar(codigo);
/*		
		if (codigo <= 999900 && obj == null) {
			throw new ObjectNotFoundException("Item Não Encontrado");
		}
*/		
		return ResponseEntity.ok().body(obj);
		
	}
	
	/*
	localhost:8082/item/descricao/algodao
	*/
	@CrossOrigin
	@RequestMapping(value="/descricao/{descricao}",method=RequestMethod.GET)
	public  ResponseEntity<List<Item>> procuraPorDescricao(
			@PathVariable String descricao) {
		List<Item> lista = service.procuraPorDescricao(descricao);
		return ResponseEntity.ok().body(lista);
	}

}
