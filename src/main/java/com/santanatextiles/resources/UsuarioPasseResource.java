package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.services.UsuarioPasseService;

@RestController
@RequestMapping(value="/usuariopasse")
public class UsuarioPasseResource {

	@Autowired
	private UsuarioPasseService service; 
	
	@RequestMapping(value="/{matricula}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String matricula) {
		
		UsuarioPasse obj = service.buscar(matricula);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
