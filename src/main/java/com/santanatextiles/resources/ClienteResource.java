package com.santanatextiles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> lista = service.listagemGeral(PassegeralApplication._EMPRESA);
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value="/descricao/{descricao}",method=RequestMethod.GET)
	public  ResponseEntity<List<Cliente>> procuraPorDescricao(@PathVariable String descricao) {
		List<Cliente> lista = service.procuraPorDescricao(PassegeralApplication._EMPRESA, descricao);
		return ResponseEntity.ok().body(lista);
	}
	
}
