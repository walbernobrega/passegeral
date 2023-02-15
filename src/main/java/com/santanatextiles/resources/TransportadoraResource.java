package com.santanatextiles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Transportadora;
import com.santanatextiles.services.TransportadoraService;

@RestController
@RequestMapping(value="/transportadora")
public class TransportadoraResource {

	@Autowired
	private TransportadoraService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String codigo) {
		
		Transportadora obj = service.buscar(PassegeralApplication._EMPRESA , codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<Transportadora>> findAll() {
		List<Transportadora> lista = service.listagemGeral(PassegeralApplication._EMPRESA);
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value="/descricao/{descricao}",method=RequestMethod.GET)
	public  ResponseEntity<List<Transportadora>> procuraPorDescricao(@PathVariable String descricao) {
		List<Transportadora> lista = service.procuraPorDescricao(PassegeralApplication._EMPRESA, descricao);
		return ResponseEntity.ok().body(lista);
	}
	
}
