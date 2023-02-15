package com.santanatextiles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<Transacao>> findAll() {
		List<Transacao> lista = service.listagemGeral(PassegeralApplication._EMPRESA);
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value="/descricao/{descricao}",method=RequestMethod.GET)
	public  ResponseEntity<List<Transacao>> procuraPorDescricao(@PathVariable String descricao) {
		List<Transacao> lista = service.procuraPorDescricao(PassegeralApplication._EMPRESA, descricao);
		return ResponseEntity.ok().body(lista);
	}
	
}
