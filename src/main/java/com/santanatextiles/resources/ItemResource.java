package com.santanatextiles.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Item;

@RestController
@RequestMapping(value="/item")
public class ItemResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Item> listar() {
		
		Item it1 = new Item("999999","PRENSA EM ALUMINIO C/ REGUA DE MAD 200");
		Item it2 = new Item("111111","CALÇAS CRUAS /P LÉO LASER");
		
		ArrayList<Item> lista = new ArrayList<>();
		lista.add(it1);
		lista.add(it2);
		
		return lista;
		
	}
}
