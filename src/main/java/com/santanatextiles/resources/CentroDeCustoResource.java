package com.santanatextiles.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.CentroDeCusto;
import com.santanatextiles.services.CentroDeCustoService;

@RestController
@RequestMapping(value="/centrodecusto")
public class CentroDeCustoResource {

	@Autowired
	private CentroDeCustoService service; 
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String codigo) {
		
		CentroDeCusto obj = service.buscar(codigo);
		
		return ResponseEntity.ok().body(obj);
		
	}

}
