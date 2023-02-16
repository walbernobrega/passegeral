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
import com.santanatextiles.domain.Cliente;
import com.santanatextiles.services.ClienteService;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String codigo) {
		
		Cliente obj = service.buscar(PassegeralApplication._EMPRESA , codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}

	/*
	localhost:8082/cliente?linesPerPage=3&page=1&direction=ASC&orderBy=descricao
	*/
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<Page<Cliente>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="descricao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Cliente> lista = service.listagemGeral(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/cliente/descricao/francisco/?linesPerPage=3&page=1&direction=ASC&orderBy=descricao
	*/
	@RequestMapping(value="/descricao/{descricao}",method=RequestMethod.GET)
	public  ResponseEntity<Page<Cliente>> procuraPorDescricao(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="descricao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable String descricao) {
		Page<Cliente> lista = service.procuraPorDescricao(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA, descricao);
		return ResponseEntity.ok().body(lista);
	}
	
}
