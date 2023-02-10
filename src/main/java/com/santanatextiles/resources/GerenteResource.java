package com.santanatextiles.resources;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Gerente;

@RestController
@RequestMapping(value="/gerente")
public class GerenteResource {

	@RequestMapping(method=RequestMethod.GET)
	public ArrayList<Gerente> listar() {
		
		Gerente ge1 = new Gerente("dalton","17071","dalton","1234","01",true);
		Gerente ge2 = new Gerente("EMENDES","30087","EDVANIA RIBEIRO MENDES","1234","01",true);
		Gerente ge3 = new Gerente("KBRUNO","27058","KASSIO BRUNO","1234","01",true);
		
		ArrayList<Gerente> lista = new ArrayList<>();
		
		lista.add(ge1);
		lista.add(ge2);
		lista.add(ge3);
		
		return lista;
		
	}
}
