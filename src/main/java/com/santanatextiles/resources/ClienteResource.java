package com.santanatextiles.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Cliente;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Cliente> listar() {
		
		Cliente cf1 = new Cliente("28010","THIAGO MOREIRA E SILVA ME","J","10379861000186");
		Cliente cf2 = new Cliente("14173","NOVA FIACAO INDUSTRIA TEXTIL S/A","J","18067083000100");
		
		ArrayList<Cliente> lista = new ArrayList<>();
		
		lista.add(cf1);
		lista.add(cf2);
		
		return lista;
		
	}

}
