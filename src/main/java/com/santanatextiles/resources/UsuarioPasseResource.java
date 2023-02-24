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
import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.services.UsuarioPasseService;
import com.santanatextiles.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/usuariopasse")
public class UsuarioPasseResource {

	@Autowired
	private UsuarioPasseService service; 
	
	@RequestMapping(value="/{matricula}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String matricula) {
		
		UsuarioPasse obj = service.buscar(PassegeralApplication._EMPRESA , matricula);

		if (obj == null) {
			throw new ObjectNotFoundException("Usuário Não Encontrado");
		}
		return ResponseEntity.ok().body(obj);
		
	}
	
	/*
	localhost:8082/usuariopasse?linesPerPage=3&page=1&direction=ASC&orderBy=nome
	*/
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<Page<UsuarioPasse>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<UsuarioPasse> lista = service.listagemGeral(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/usuariopasse/nome/administracao/?linesPerPage=3&page=1&direction=ASC&orderBy=nome
	*/
	
	@RequestMapping(value="/nome/{nome}",method=RequestMethod.GET)
	public  ResponseEntity<Page<UsuarioPasse>> procuraPorNome(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable String nome) {
		Page<UsuarioPasse> lista = service.procuraPorNome(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA, nome);
		return ResponseEntity.ok().body(lista);
	}
	
}
