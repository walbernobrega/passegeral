package com.santanatextiles.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.RetornoItemPasseGeral;

@RestController
@RequestMapping(value="/retornoitempassegeral")
public class RetornoItemPasseGeralResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ArrayList<RetornoItemPasseGeral> listar() throws ParseException {
		
		Float val = Float.parseFloat("0");
		
		RetornoItemPasseGeral it1 = new RetornoItemPasseGeral(
				"047654", 
				"999999", 
				"FLASHPROM R-60",
				new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2023"), 
				"08:48",
				null, 
				null, 
				val, 
				null, 
				null,
				null, 
				val, 
				"NOTA FISCAL POR EMAIL", 
				null);
		
		RetornoItemPasseGeral it2 = new RetornoItemPasseGeral(
				"047788", 
				"999999", 
				"PRENSA EM ALUMINIO C/ REGUA DE MAD 200",
				new SimpleDateFormat("dd/MM/yyyy").parse("07/02/2023"), 
				"13:59",
				null, 
				null, 
				val, 
				null, 
				null,
				null, 
				val, 
				null, 
				null);
		
		ArrayList<RetornoItemPasseGeral> lista = new ArrayList<>();
		lista.add(it1);
		lista.add(it2);
		
		return lista;
		
	}

}
