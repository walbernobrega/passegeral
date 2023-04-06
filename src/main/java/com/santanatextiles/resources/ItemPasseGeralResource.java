package com.santanatextiles.resources;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.ItemPasseGeral;
import com.santanatextiles.services.ItemPasseGeralService;

@RestController
@RequestMapping(value="/itempassegeral")
public class ItemPasseGeralResource {

	@Autowired
	private ItemPasseGeralService service; 
	
	@CrossOrigin
	@RequestMapping(value="/{numeroPasse}/{codigoItem}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String numeroPasse, @PathVariable String codigoItem) {
		
		ItemPasseGeral obj = service.buscar(PassegeralApplication._EMPRESA ,numeroPasse,codigoItem); 
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	/*
	localhost:8082/itempassegeral/{numeroPasse}/{codigoItem}/lancarvalor
	{
	    "valor" : 2566.36
	}
	*/
	@CrossOrigin
	@RequestMapping(value="{numeroPasse}/{codigoItem}/lancarvalor",method=RequestMethod.POST)
	public ResponseEntity<String> lancaValorItemPasseGeral(@PathVariable String numeroPasse,
			@PathVariable String codigoItem,
			@RequestBody Map<String , Object> dados) throws Exception {
		ItemPasseGeral obj = service.lancaValorItemPasseGeral(
				numeroPasse,
				codigoItem,
				Float.valueOf(dados.get("valor").toString())
				);
		return ResponseEntity.status(HttpStatus.OK).body("Valor Lançado no Item: " + obj.getNumeroPasse());
	}
	

}
