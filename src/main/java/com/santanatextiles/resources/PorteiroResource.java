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
import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.services.PorteiroService;

@RestController
@RequestMapping(value="/porteiro")
public class PorteiroResource {

	@Autowired
	private PorteiroService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String codigo) {
		
		Porteiro obj = service.buscar(PassegeralApplication._EMPRESA , codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	/*
	localhost:8082/porteiro?linesPerPage=3&page=1&direction=ASC&orderBy=nome
	*/
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<Page<Porteiro>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="descricao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Porteiro> lista = service.listagemGeral(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/porteiro/descricao/administracao/?linesPerPage=3&page=1&direction=ASC&orderBy=nome
	*/
	@RequestMapping(value="/nome/{nome}",method=RequestMethod.GET)
	public  ResponseEntity<Page<Porteiro>> procuraPorDescricao(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="descricao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable String nome) {
		Page<Porteiro> lista = service.procuraPorNome(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA, nome);
		return ResponseEntity.ok().body(lista);
	}
	
}
