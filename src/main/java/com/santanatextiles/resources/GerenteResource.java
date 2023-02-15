package com.santanatextiles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<Gerente>> findAll() {
		List<Gerente> lista = service.listagemGeral(PassegeralApplication._EMPRESA);
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value="/nome/{nome}",method=RequestMethod.GET)
	public  ResponseEntity<List<Gerente>> procuraPorDescricao(@PathVariable String nome) {
		List<Gerente> lista = service.procuraPorNome(PassegeralApplication._EMPRESA, nome);
		return ResponseEntity.ok().body(lista);
	}
	
}
