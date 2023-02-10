package com.santanatextiles.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Fornecedor;

@RestController
@RequestMapping(value="/fornecedor")
public class FornecedorResource {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Fornecedor> listar() {
		
		Fornecedor cf1 = new Fornecedor("28010","THIAGO MOREIRA E SILVA ME","J","10379861000186");
		Fornecedor cf2 = new Fornecedor("14173","NOVA FIACAO INDUSTRIA TEXTIL S/A","J","18067083000100");
		
		ArrayList<Fornecedor> lista = new ArrayList<>();
		
		lista.add(cf1);
		lista.add(cf2);
		
		return lista;
		
	}

}
