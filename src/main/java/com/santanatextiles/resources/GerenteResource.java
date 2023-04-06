package com.santanatextiles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Gerente;
import com.santanatextiles.services.GerenteService;
import com.santanatextiles.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/gerente")
public class GerenteResource {

	@Autowired
	private GerenteService service; 
	
	@CrossOrigin
	@RequestMapping(value="/{matricula}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String matricula) {
		
		Gerente obj = service.buscar(PassegeralApplication._EMPRESA , matricula);
		
		if (obj == null) {
			throw new ObjectNotFoundException("Gerente Não Encontrado");
		}
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	/*
	localhost:8082/gerente
	*/
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<Gerente>> findAll() {
		List<Gerente> lista = service.listagemGeral(PassegeralApplication._EMPRESA);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/gerente/nome/bruno
	*/
	@CrossOrigin
	@RequestMapping(value="/nome/{nome}",method=RequestMethod.GET)
	public  ResponseEntity<List<Gerente>> procuraPorDescricao(
			@PathVariable String nome) {
		List<Gerente> lista = service.procuraPorNome(PassegeralApplication._EMPRESA, nome);
		return ResponseEntity.ok().body(lista);
	}
	
}
