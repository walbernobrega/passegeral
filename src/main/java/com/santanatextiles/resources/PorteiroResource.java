package com.santanatextiles.resources;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Porteiro;

@RestController
@RequestMapping(value="/porteiro")
public class PorteiroResource {

	@RequestMapping(method=RequestMethod.GET)
	public ArrayList<Porteiro> listar() {
		
		Porteiro pr1 = new Porteiro("30087","EDVANIA RIBEIRO","1234","01");
		Porteiro pr2 = new Porteiro("02029","EVANDO NOGUEIRA DA SILVA","1234","01");
		Porteiro pr3 = new Porteiro("32035","MACIANO VENTURA DE OLIVEIRA","1234","01");
				
		ArrayList<Porteiro> lista = new ArrayList<>();
		
		lista.add(pr1);
		lista.add(pr2);
		lista.add(pr3);
		
		return lista;
		
	}
}
