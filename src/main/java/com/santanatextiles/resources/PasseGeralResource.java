package com.santanatextiles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.services.PasseGeralService;

@RestController
@RequestMapping(value="/passegeral")
public class PasseGeralResource {

	@Autowired
	private PasseGeralService service; 
	
	@RequestMapping(value="/{numeroPasse}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String numeroPasse) {
		
		PasseGeral obj = service.buscar(PassegeralApplication._EMPRESA , numeroPasse);
		
		return ResponseEntity.ok().body(obj);
		
	}
	/*
	localhost:8082/passegeral?linesPerPage=3&page=1&direction=ASC&orderBy=fornecedor.descricao
	*/
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<Page<PasseGeral>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="dataInclusao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<PasseGeral> lista = service.listagemGeral(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value="/portador/{portador}",method=RequestMethod.GET)
	public  ResponseEntity<List<PasseGeral>> procuraPorPortador(@PathVariable String portador) {
		List<PasseGeral> lista = service.procuraPorPortador(PassegeralApplication._EMPRESA, portador);
		return ResponseEntity.ok().body(lista);
	}
	
	/*
	localhost:8082/passegeral/averificar/?linesPerPage=3&page=1&direction=ASC&orderBy=dataInclusao
	*/
	@RequestMapping(value="/averificar",method=RequestMethod.GET)
	public  ResponseEntity<Page<PasseGeral>> passesNaoVerificados(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="j0dtin") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<PasseGeral> lista = service.passesNaoVerificados(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/passegeral/naoaprovados/{gerente}?linesPerPage=3&page=1&direction=ASC&orderBy=dataInclusao
	*/
	@RequestMapping(value="/naoaprovados/{gerente}",method=RequestMethod.GET)
	public  ResponseEntity<Page<PasseGeral>> passesNaoAprovados(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="j0dtin") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable String gerente) {
		Page<PasseGeral> lista = service.passesNaoAprovados(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA, gerente);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/passegeral/dousuario/{autor}?linesPerPage=3&page=1&direction=ASC&orderBy=dataInclusao
	*/
	@RequestMapping(value="/dousuario/{autor}",method=RequestMethod.GET)
	public  ResponseEntity<Page<PasseGeral>> passesDoUsuario(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="j0dtin") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable String autor) {
		Page<PasseGeral> lista = service.passesDoUsuario(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA, autor);
		return ResponseEntity.ok().body(lista);
	}
	
}
