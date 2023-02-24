package com.santanatextiles.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.RetornoItemPasseGeral;
import com.santanatextiles.services.RetornoItemPasseGeralService;

@RestController
@RequestMapping(value="/retornoitempassegeral")
public class RetornoItemPasseGeralResource {

	@Autowired
	private RetornoItemPasseGeralService service; 
	
	@RequestMapping(value="/{numeroPasse}/{codigoItem}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String numeroPasse,@PathVariable String codigoItem) {
		
		RetornoItemPasseGeral obj = service.buscar(PassegeralApplication._EMPRESA,numeroPasse,codigoItem); 
		
		return ResponseEntity.ok().body(obj);
		
	}

}
