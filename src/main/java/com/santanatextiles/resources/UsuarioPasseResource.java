package com.santanatextiles.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.services.UsuarioPasseService;

@RestController
@RequestMapping(value="/usuariopasse")
public class UsuarioPasseResource {

	@Autowired
	private UsuarioPasseService service; 
	
	@RequestMapping(value="/{matricula}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String matricula) {
		
		UsuarioPasse obj = service.buscar(PassegeralApplication._EMPRESA , matricula);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<List<UsuarioPasse>> findAll() {
		List<UsuarioPasse> lista = service.listagemGeral(PassegeralApplication._EMPRESA);
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value="/nome/{nome}",method=RequestMethod.GET)
	public  ResponseEntity<List<UsuarioPasse>> procuraPorDescricao(@PathVariable String nome) {
		List<UsuarioPasse> lista = service.procuraPorNome(PassegeralApplication._EMPRESA, nome);
		return ResponseEntity.ok().body(lista);
	}
	
}
