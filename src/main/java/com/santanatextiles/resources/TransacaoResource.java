package com.santanatextiles.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Transacao;

@RestController
@RequestMapping(value="/transacao")
public class TransacaoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Transacao> listar() {
		
		Transacao tr1 = new Transacao("001","COMPRAS DIVERSAS","27058000000000000000000000000000000000000000000000");
		Transacao tr2 = new Transacao("040","AMOSTRA PECAS DE MAQUINA","27058170710000000000000000000000000000000000000000");
		
		ArrayList<Transacao> lista = new ArrayList<>();
		
		lista.add(tr1);
		lista.add(tr2);
		
		return lista;
	}

}
