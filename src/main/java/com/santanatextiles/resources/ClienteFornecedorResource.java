package com.santanatextiles.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.ClienteFornecedor;

@RestController
@RequestMapping(value="/clientefornecedor")
public class ClienteFornecedorResource {
	
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ClienteFornecedor> listar() {
		
		ClienteFornecedor cf1 = new ClienteFornecedor("28010","THIAGO MOREIRA E SILVA ME","J","10379861000186");
		ClienteFornecedor cf2 = new ClienteFornecedor("14173","NOVA FIACAO INDUSTRIA TEXTIL S/A","J","18067083000100");
		
		ArrayList<ClienteFornecedor> lista = new ArrayList<>();
		
		lista.add(cf1);
		lista.add(cf2);
		
		return lista;
		
	}

}
