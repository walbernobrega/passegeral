package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.Fornecedor;
import com.santanatextiles.services.FornecedorService;

@RestController
@RequestMapping(value="/fornecedor")
public class FornecedorResource {

	@Autowired
	private FornecedorService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String codigo) {
		
		Fornecedor obj = service.buscar(codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
