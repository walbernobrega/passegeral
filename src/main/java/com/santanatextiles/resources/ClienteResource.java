package com.santanatextiles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Cliente;
import com.santanatextiles.services.ClienteService;
import com.santanatextiles.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService service; 
	
	@CrossOrigin
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String codigo) {
		
		Cliente obj = service.buscar(PassegeralApplication._EMPRESA , codigo);
		
		if (obj == null) {
			throw new ObjectNotFoundException("Cliente Não Encontrado");
		}
		
		return ResponseEntity.ok().body(obj);
		
	}

	/*
	localhost:8082/cliente?linesPerPage=3&page=1&direction=ASC&orderBy=descricao
	*/
	@CrossOrigin
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
	@CrossOrigin
	@RequestMapping(value="/descricao/{descricao}",method=RequestMethod.GET)
	public  ResponseEntity<List<Cliente>> procuraPorDescricao(
			@PathVariable String descricao) {
		List<Cliente> lista = service.procuraPorDescricao(PassegeralApplication._EMPRESA, descricao);
		return ResponseEntity.ok().body(lista);
	}
	
}
