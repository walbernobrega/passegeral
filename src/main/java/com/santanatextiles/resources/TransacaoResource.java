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
import com.santanatextiles.domain.Transacao;
import com.santanatextiles.services.TransacaoService;

@RestController
@RequestMapping(value="/transacao")
public class TransacaoResource {

	@Autowired
	private TransacaoService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String codigo) {
		
		Transacao obj = service.buscar(PassegeralApplication._EMPRESA , codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	/*
	localhost:8082/transacao?linesPerPage=3&page=1&direction=ASC&orderBy=descricao
	*/
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<Page<Transacao>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="descricao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Transacao> lista = service.listagemGeral(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/transacao/descricao/algodao/?linesPerPage=3&page=1&direction=ASC&orderBy=descricao
	*/
	@RequestMapping(value="/descricao/{descricao}",method=RequestMethod.GET)
	public  ResponseEntity<Page<Transacao>> procuraPorDescricao(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="descricao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable String descricao) {
		Page<Transacao> lista = service.procuraPorDescricao(page, linesPerPage, orderBy, direction, descricao);
		return ResponseEntity.ok().body(lista);
	}
	
}
