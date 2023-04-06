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
import com.santanatextiles.domain.FornecedorCliente;
import com.santanatextiles.services.FornecedorClienteService;

@RestController
@RequestMapping(value="/fornecedorcliente")
public class FornecedorClienteResource {

	@Autowired
	private FornecedorClienteService service; 
	
	@CrossOrigin
	@RequestMapping(value="/{entidade}/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String entidade,@PathVariable String codigo) {
		
		FornecedorCliente obj = service.buscar(PassegeralApplication._EMPRESA , entidade , codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	/*
	localhost:8082/fornecedorcliente?linesPerPage=3&page=1&direction=ASC&orderBy=nome
	*/
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<Page<FornecedorCliente>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="descricao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<FornecedorCliente> lista = service.listagemGeral(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/fornecedorcliente/nome/administracao/?linesPerPage=3&page=1&direction=ASC&orderBy=nome
	*/
	@CrossOrigin
	@RequestMapping(value="/nome/{nome}",method=RequestMethod.GET)
	public  ResponseEntity<List<FornecedorCliente>> procuraPorDescricao(
			@PathVariable String nome) {
		List<FornecedorCliente> lista = service.procuraPorNome(PassegeralApplication._EMPRESA, nome);
		return ResponseEntity.ok().body(lista);
	}
	
}
