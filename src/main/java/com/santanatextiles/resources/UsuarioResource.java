package com.santanatextiles.resources;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.services.UsuarioService;

@RestController
@RequestMapping(value="/passegeral")
public class UsuarioResource {

	@Autowired
	private UsuarioService usuarioService;
	
	/*
	localhost:8082/passegeral/login
	{
	    "codigo" : "27058",
	    "senha" : "1234",
	    "idfil" : "01"
	}
	*/
	@CrossOrigin(origins = "*")
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody Map<String , Object> dados) {
		
		String idfil = dados.get("idfil").toString();
		String codigo = dados.get("codigo").toString();
		String senha= dados.get("senha").toString();

		return ResponseEntity.ok().body(usuarioService.verificaLogin(codigo, senha, idfil));
		
	}
	
}
