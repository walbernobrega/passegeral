package com.santanatextiles.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Transportadora;

@RestController
@RequestMapping(value="/transportadora")
public class TransportadoraResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Transportadora> listar() {
		Transportadora tr1 = new Transportadora("0000","SEM TRANSPORTADORA");
		Transportadora tr2 = new Transportadora("0019","ANTENOR TRANSPORTES");
		
		ArrayList<Transportadora> lista = new ArrayList<>();
		
		lista.add(tr1);
		lista.add(tr2);
		
		return lista;
		
	}
}
