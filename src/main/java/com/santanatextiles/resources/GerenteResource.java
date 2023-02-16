package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Gerente;
import com.santanatextiles.services.GerenteService;

@RestController
@RequestMapping(value="/gerente")
public class GerenteResource {

	@Autowired
	private GerenteService service; 
	
	@RequestMapping(value="/{matricula}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String matricula) {
		
		Gerente obj = service.buscar(PassegeralApplication._EMPRESA , matricula);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	/*
	localhost:8082/centrodecusto?linesPerPage=3&page=1&direction=ASC&orderBy=descricao
	*/
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<Page<Gerente>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="descricao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Gerente> lista = service.listagemGeral(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/centrodecusto/descricao/administracao/?linesPerPage=3&page=1&direction=ASC&orderBy=descricao
	*/
	@RequestMapping(value="/nome/{nome}",method=RequestMethod.GET)
	public  ResponseEntity<Page<Gerente>> procuraPorDescricao(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="descricao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable String nome) {
		Page<Gerente> lista = service.procuraPorNome(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA, nome);
		return ResponseEntity.ok().body(lista);
	}
	
}
